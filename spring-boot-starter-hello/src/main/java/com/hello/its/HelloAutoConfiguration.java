package com.hello.its;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 基于java config 配置该类
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/7/11 11:40
 */
@Configuration
/**
 * 启用属性配置 通过@Autowired 注入该属性
 */
@EnableConfigurationProperties(HelloProperties.class)
/**
 * 判断HelloService这个类在类路径下是否存在
 */
@ConditionalOnClass(HelloService.class)
@ConditionalOnProperty(prefix = "hello",value = "enabled",matchIfMissing = true)
public class HelloAutoConfiguration {

    /**
     * 当前HelloService 需要的配置信息
     */
    @Autowired
    HelloProperties helloProperties;

    /**
     * 5 -> 当容器中没有这个bean的情况下 基于java config 自动配置这个bean
     * @return HelloService
     */
    @Bean // 4 -> 基于java config 自动配置这个bean
    @ConditionalOnMissingBean(HelloService.class) // 5
    public HelloService helloService(){
        HelloService helloService = new HelloService();
        helloService.sayHello(helloProperties.getMsg());
        return helloService;
    }

}
