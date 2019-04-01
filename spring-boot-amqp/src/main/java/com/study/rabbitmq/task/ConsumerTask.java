package com.study.rabbitmq.task;

import com.study.rabbitmq.consumer.AuthTestQueueConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
    /** 添加定时任务 直接指定时间间隔，例如：1秒 **/
    @Scheduled(cron = "0/1 * * * * ?")
    public void  consumerTask(){
        log.info(" 执行一次 ");
    }
}
