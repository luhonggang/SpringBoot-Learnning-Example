package com.study.rabbitmq.config;

import com.study.rabbitmq.common.QueueUtil;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/1/16 14:30
 */
@Configuration
public class RabbitConfig {

    private static final int MAX_CONCURRENT_CONSUMERS = 3;
    @Primary
    @Bean(name="appConnectionFactory")
    public ConnectionFactory appConnectionFactory(
            @Value("${spring.rabbitmq.app.host}") String host,
            @Value("${spring.rabbitmq.app.port}") int port,
            @Value("${spring.rabbitmq.app.username}") String username,
            @Value("${spring.rabbitmq.app.password}") String password,
            @Value("${spring.rabbitmq.app.virtualHost}") String virtualHost,
            @Value("${spring.rabbitmq.app.connection-timeout}") int timeout){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        connectionFactory.setConnectionTimeout(timeout);
        connectionFactory.setPublisherConfirms(true); //必须要设置
        return connectionFactory;
//        return connectionFactory(host,port,username,password,virtualHost,timeout);
    }

//    @Bean
//    public Queue helloQueue(){
//        return new Queue(QueueUtil.AUTH_USER_QUEUE);
//    }

    /**
     *
     * @param host
     * @param port
     * @param username
     * @param password
     * @param virtualHost
     * @param timeout
     * @return
     */
    public CachingConnectionFactory  connectionFactory(String host,int port,String username,String password,String virtualHost,int timeout){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        connectionFactory.setConnectionTimeout(timeout);
        return connectionFactory;
    }
    @Primary
    @Bean(name="appRabbitTemplate")
    public RabbitTemplate appRabbitTemplate(@Qualifier("appConnectionFactory") ConnectionFactory connectionFactory){
        RabbitTemplate firstRabbitTemplate = new RabbitTemplate(connectionFactory);
        return firstRabbitTemplate;
    }

    @Primary
    @Bean(name="appFactory")
    public SimpleRabbitListenerContainerFactory appFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer,
                                                           @Qualifier("appConnectionFactory") ConnectionFactory connectionFactory){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setMaxConcurrentConsumers(MAX_CONCURRENT_CONSUMERS);
        factory.setConcurrentConsumers(1);
        configurer.configure(factory, connectionFactory);
        return factory;
    }


//    @Bean(name="electConnectionFactory")
//    public ConnectionFactory electConnectionFactory(
//            @Value("${spring.rabbitmq.elect.host}") String host,
//            @Value("${spring.rabbitmq.elect.port}") int port,
//            @Value("${spring.rabbitmq.elect.username}") String username,
//            @Value("${spring.rabbitmq.elect.password}") String password,
//            @Value("${spring.rabbitmq.elect.virtualHost}") String virtualHost,
//            @Value("${spring.rabbitmq.elect.connection-timeout}") int timeout){
//        return connectionFactory(host,port,username,password,virtualHost,timeout);
//    }
//
//    @Bean(name="electRabbitTemplate")
//    public RabbitTemplate electRabbitTemplate(@Qualifier("electConnectionFactory") ConnectionFactory connectionFactory){
//        RabbitTemplate firstRabbitTemplate = new RabbitTemplate(connectionFactory);
//        return firstRabbitTemplate;
//    }
//
//    @Bean(name="electFactory")
//    public SimpleRabbitListenerContainerFactory electFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer,
//                                                             @Qualifier("electConnectionFactory") ConnectionFactory connectionFactory){
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        configurer.configure(factory, connectionFactory);
//        return factory;
//    }
}
