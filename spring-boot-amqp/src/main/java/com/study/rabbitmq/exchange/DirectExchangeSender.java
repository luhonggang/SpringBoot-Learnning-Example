//package com.study.rabbitmq.exchange;
//
//import com.study.rabbitmq.common.QueueEnum;
//import com.study.rabbitmq.common.QueueUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
///**
// * MQ生产消息端
// * 参考地址 : https://www.cnblogs.com/ityouknow/p/6120544.html
// * @author luhonggang
// * @version 1.8.0
// * @date 2019/1/16 11:25
// */
//@Component
//@Slf4j
//public class DirectExchangeSender {
//
//    @Resource(name = "appRabbitTemplate")
//    AmqpTemplate amqpTemplate;
//
//    public void send(Object message){
//        String msg = (String) message;
//        log.info("send msg : " + message);
//        amqpTemplate.convertAndSend(QueueEnum.AUTH_USER_QUEUE.getQueue(),msg);
//        // 如下的方式待实现
////        amqpTemplate.convertAndSend(QueueEnum.AUTH_USER_QUEUE.getExchange(),QueueEnum.AUTH_USER_QUEUE.getRoutingKey(),msg);
//    }
//}
