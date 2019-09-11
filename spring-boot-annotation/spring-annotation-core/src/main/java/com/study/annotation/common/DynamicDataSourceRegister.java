package com.study.annotation.common;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.bind.RelaxedDataBinder;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 如下是基于springboot 1.5.x 版本实现的配置
 * * springboot 2.0.x 另换配置方式
 */
@SuppressWarnings("all")
public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceRegister.class);
    /**
     * 如配置文件中未指定数据源类型，使用该默认值
     */
    private static final Object DATASOURCE_TYPE_DEFAULT = "org.apache.tomcat.jdbc.pool.DataSource";
    private ConversionService conversionService = new DefaultConversionService();
    private PropertyValues dataSourcePropertyValues;
    /**
     * 默认数据源
     */
    private DataSource defaultDataSource;
    private Map<String, DataSource> customDataSources = new HashMap<String, DataSource>();


    @Override
    public void setEnvironment(Environment environment) {
        logger.info("========== DynamicDataSourceRegister.setEnvironment() =========");
        logger.info("======== environment :{}", JSON.toJSONString(environment));

        initDefaultDataSource(environment);

//        initSsoDataSources(environment);

        initCustomDataSources(environment);

    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        logger.info("========= DynamicDataSourceRegister.registerBeanDefinitions() ========");
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        // 将主数据源添加到更多数据源中
        targetDataSources.put("dataSource", defaultDataSource);
        DynamicDataSourceContextHolder.dataSourceIds.add("dataSource");
        // 添加更多数据源
        targetDataSources.putAll(customDataSources);
        for (String key : customDataSources.keySet()) {
            DynamicDataSourceContextHolder.dataSourceIds.add(key);
            logger.info("===========  配置的数据库连接名称 ： " + key);
        }
        logger.info("===========  dataSourceIds : {} ===============", JSON.toJSONString(DynamicDataSourceContextHolder.dataSourceIds));
        // 创建DynamicDataSource
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        beanDefinition.setSynthetic(true);
        MutablePropertyValues mpv = beanDefinition.getPropertyValues();
        //添加属性：AbstractRoutingDataSource.defaultTargetDataSource
        mpv.addPropertyValue("defaultTargetDataSource", defaultDataSource);

        mpv.addPropertyValue("targetDataSources", targetDataSources);

        beanDefinitionRegistry.registerBeanDefinition("dataSource", beanDefinition);
    }


    /**
     * 加载主数据源配置.
     *
     * @param env
     */
    private void initDefaultDataSource(Environment env) {
        // 读取主数据源
        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
        Map<String, Object> dsMap = new HashMap<String, Object>();
        dsMap.put("type", propertyResolver.getProperty("type"));
        dsMap.put("driverClassName", propertyResolver.getProperty("driverClassName"));
        dsMap.put("url", propertyResolver.getProperty("url"));
        dsMap.put("username", propertyResolver.getProperty("username"));
        dsMap.put("password", propertyResolver.getProperty("password"));
        //创建数据源;
        logger.info("========= initDefaultDataSource :{}", JSON.toJSONString(dsMap));
        defaultDataSource = buildDataSource(dsMap);
        dataBinder(defaultDataSource, env);
    }

//    /**
//     * 初始化单点登录数据源
//     *
//     */
//    private void initSsoDataSources(Environment env) {
//
//        // 读取配置文件获取更多数据源，也可以通过defaultDataSource读取数据库获取更多数据源
//        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(env, "sso.datasource.");
//        if(!Detect.notEmpty(propertyResolver.getProperty("username"))){
//            return;
//        }
//        Map<String, Object> dsMap = new HashMap<String, Object>();
//        dsMap.put("type", propertyResolver.getProperty("type"));
//        dsMap.put("driverClassName", propertyResolver.getProperty("driver-class-name"));
//        dsMap.put("url", propertyResolver.getProperty("url"));
//        dsMap.put("username", propertyResolver.getProperty("username"));
//        dsMap.put("password", propertyResolver.getProperty("password"));
//        //创建数据源;
//        logger.info("========= initSsoDataSources sso.datasource {}", JSON.toJSONString(dsMap));
//        DataSource ds = buildDataSource(dsMap);
//        //添加数据源配置到
//        customDataSources.put("sso",ds);
//        DynamicDataSourceContextHolder.setDataSourceType("sso");
//        dataBinder(ds, env);
//    }

    /**
     * 初始化多数据源 配置读取
     *
     * @param env 环境配置
     */
    private void initCustomDataSources(Environment env) {
        // 读取配置文件获取更多数据源，也可以通过defaultDataSource读取数据库获取更多数据源
        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(env, "custom.datasource.");
        String dsPrefixs = propertyResolver.getProperty("names");
        logger.info("====== init other DataSource custom.datasource = {}", JSON.toJSONString(dsPrefixs));
        // 多个数据源
        for (String dsPrefix : dsPrefixs.split(",")) {
            Map<String, Object> dsMap = propertyResolver.getSubProperties(dsPrefix + ".");
            DataSource ds = buildDataSource(dsMap);
            //添加数据源配置到
            customDataSources.put(dsPrefix, ds);
            DynamicDataSourceContextHolder.setDataSourceType(dsPrefix);
            dataBinder(ds, env);
            logger.info("++++++++++++ 数据源名称 ++++++++++++", dsPrefix);
        }
    }

    /**
     * 绑定数据源实现
     *
     * @param dsMap 数据源类型
     * @return DataSource
     */
    public DataSource buildDataSource(Map<String, Object> dsMap) {
        Object type = dsMap.get("type");
        if (type == null) {
            // 默认DataSource
            type = DATASOURCE_TYPE_DEFAULT;
        }
        Class<? extends DataSource> dataSourceType;
        try {
            dataSourceType = (Class<? extends DataSource>) Class.forName((String) type);
            String driverClassName = dsMap.get("driverClassName").toString();
            String url = dsMap.get("url").toString();
            String username = dsMap.get("username").toString();
            String password = dsMap.get("password").toString();
            DataSourceBuilder factory = DataSourceBuilder.create().driverClassName(driverClassName).url(url).username(username).password(password).type(dataSourceType);
            return factory.build();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 为DataSource绑定更多数据
     *
     * @param dataSource
     * @param env
     */
    private void dataBinder(DataSource dataSource, Environment env) {

        RelaxedDataBinder dataBinder = new RelaxedDataBinder(dataSource);
        dataBinder.setConversionService(conversionService);
        dataBinder.setIgnoreNestedProperties(false);
        dataBinder.setIgnoreInvalidFields(false);
        dataBinder.setIgnoreUnknownFields(true);
        if (dataSourcePropertyValues == null) {
            Map<String, Object> rpr = new RelaxedPropertyResolver(env, "spring.datasource").getSubProperties(".");
            logger.info("=== spring.datasource :{}========", JSON.toJSONString(rpr));
            logger.info("初始化 Druid 连接池");
            Map<String, Object> values = new HashMap<>(rpr);
            // 排除已经设置的属性
            values.remove("type");
            values.remove("driver-class-name");
            values.remove("url");
            values.remove("username");
            values.remove("password");
            dataSourcePropertyValues = new MutablePropertyValues(values);
        }
        dataBinder.bind(dataSourcePropertyValues);
    }
}
