//package com.study.rabbitmq.exchange;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
///**
// * 模拟一个生产者 多个消费者的场景 (分别创建Receiver 和 Receiver2 2个消费者类来消费)
// * @author luhonggang
// * @version 1.8.0
// * @date 2019/1/16 16:31
// */
//@RabbitListener(queues = {"hello"})
//@Component
//@Slf4j
//public class Receiver{
//    @RabbitHandler
//    public void handler(String content){
//        log.info("消费端01接收到消息 ：" + content);
//    }
//}
