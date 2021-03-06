package com.study.annotation;

import com.study.annotation.common.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 多数据源配置
 * @author luhonggang
 * @Import 实现将 DynamicDataSourceRegister 类的实例注入到SpringIOC中
 */
@SpringBootApplication
@EnableTransactionManagement
@Import({DynamicDataSourceRegister.class})
public class AnnotationApplication extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext run = SpringApplication.run(AnnotationApplication.class, args);
    }
}
