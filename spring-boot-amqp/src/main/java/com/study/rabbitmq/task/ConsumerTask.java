package com.study.rabbitmq.task;

import com.study.rabbitmq.common.QueueEnum;
import com.study.rabbitmq.consumer.AuthTestQueueConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/3/28 22:04
 */
@Component
@Slf4j
public class ConsumerTask {

    @Autowired
    AuthTestQueueConsumer authTestQueueConsumer;

    @Resource(name="appRabbitTemplate")
    private RabbitTemplate appRabbitTemplate;

    ThreadLocal<Integer> currentVal = new ThreadLocal<>();

    /** 添加定时任务 直接指定时间间隔，例如：1秒 **/
    @Scheduled(cron = "0/1 * * * * ?")
    public void  consumerTask(){
        if(null == currentVal.get()){
            currentVal.set(1);
        }
        log.info(" 获取的threadlocal值 =" + currentVal.get());
        String msg = "第"+ currentVal.get() +" 次发送消息";
        appRabbitTemplate.convertAndSend(QueueEnum.AUTH_TEST_QUEUE.getExchange(),QueueEnum.AUTH_TEST_QUEUE.getRoutingKey(),msg);
        currentVal.set(currentVal.get() + 1);
    }
}
