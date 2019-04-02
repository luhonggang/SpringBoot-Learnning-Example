package com.study.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author luhonggang
 *
 */
@SpringBootApplication
@EnableScheduling
public class RabbitMqApplication extends SpringBootServletInitializer /*implements CommandLineRunner*/ {

    public static void main( String[] args )
    {

        ConfigurableApplicationContext run = SpringApplication.run(RabbitMqApplication.class, args);
    }

//    @Override
//    public void run(String... strings) throws Exception {
//        logger.info("++++++++++ 程序启动开始执行 ++++++++++");
//        String msg = " 测试消息发送开始 ";
//        appRabbitTemplate.convertAndSend(QueueEnum.AUTH_TEST_QUEUE.getExchange(),QueueEnum.AUTH_TEST_QUEUE.getRoutingKey(),msg);
//
//        logger.info(" 第一次 发送成功 ");
//        // 获取到消息
//
////        convertAndSend(QueuesEnum.AUTH_ARRAIGNMENT_QUEUE.getExchange(), QueuesEnum.AUTH_ARRAIGNMENT_QUEUE.getRoutingKey(), JSON.toJSONString(cuMaterialTask));
////        amqpTemplate.convertAndSend(QueueEnum.AUTH_USER_QUEUE.getExchange(),QueueEnum.AUTH_USER_QUEUE.getRoutingKey(),msg);
//    }
}
