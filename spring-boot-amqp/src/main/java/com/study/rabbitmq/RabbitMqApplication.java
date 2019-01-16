package com.study.rabbitmq;

import com.study.rabbitmq.common.QueueEnum;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * @author luhonggang
 *
 */
@SpringBootApplication
public class RabbitMqApplication extends SpringBootServletInitializer implements CommandLineRunner {

//    @Resource(name = "appRabbitTemplate")
//    AmqpTemplate amqpTemplate;

    public static void main( String[] args )
    {

        ConfigurableApplicationContext run = SpringApplication.run(RabbitMqApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        String msg = " 测试消息发送开始 ";
//        amqpTemplate.convertAndSend(QueueEnum.AUTH_USER_QUEUE.getExchange(),QueueEnum.AUTH_USER_QUEUE.getRoutingKey(),msg);
    }
}
