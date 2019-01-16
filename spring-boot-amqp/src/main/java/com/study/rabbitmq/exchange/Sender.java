package com.study.rabbitmq.exchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/1/16 16:30
 */
@Component
@Slf4j
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(int i){
        String content = "hello : " +i+"次 ---> "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        amqpTemplate.convertAndSend("hello", content);
        log.info("发送消息 ：" + content);
    }
}
