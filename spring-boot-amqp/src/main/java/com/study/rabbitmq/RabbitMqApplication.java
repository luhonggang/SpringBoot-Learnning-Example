package com.study.rabbitmq;

import com.study.rabbitmq.common.QueueEnum;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

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

//    /** 添加定时任务 直接指定时间间隔，例如：1秒 **/
//    @Scheduled(cron = "0/1 * * * * ?")
//    public void  consumerTask(){
//        logger.info(" ++++++++++++++++++++ 执行开始 ++++++++++++++++++++ ");
//        String msg = " 测试消息发送开始 ";
//        appRabbitTemplate.convertAndSend(QueueEnum.AUTH_TEST_QUEUE.getExchange(),QueueEnum.AUTH_TEST_QUEUE.getRoutingKey(),msg);
//    }
}
