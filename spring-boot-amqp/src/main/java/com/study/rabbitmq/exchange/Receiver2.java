package com.study.rabbitmq.exchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/1/16 18:13
 */
@RabbitListener(queues = {"hello"})
@Component
@Slf4j
public class Receiver2{
    @RabbitHandler
    public void handler(String content){
        log.info("消费端02接收到消息 ：" + content);
    }
}