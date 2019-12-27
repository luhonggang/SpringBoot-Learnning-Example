package com.study.rabbitmq.consumer;

import com.study.rabbitmq.common.QueueUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息接收端进行消息的消费
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/3/28 21:58
 */
@Component
@Slf4j
public class AuthTestQueueConsumer {

    private static final String DEFAULT_CHART="UTF-8";

    @RabbitListener(queues = QueueUtil.AUTH_TEST_QUEUE, containerFactory="appFactory")
    public void material(Message message){
        if(null == message || null == message.getBody() || message.getBody().length < 1){
            return;
        }
        try{
            String body  = new String(message.getBody(), DEFAULT_CHART);
            log.info("消费端接收到的消息 : " + body);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
