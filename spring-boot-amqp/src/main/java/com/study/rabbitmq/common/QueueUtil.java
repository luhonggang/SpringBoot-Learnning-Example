package com.study.rabbitmq.common;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/1/16 11:58
 */
public class QueueUtil {
    public  static  final String AUTH_USER_QUEUE="AUTH_USER_QUEUE";

    public  static  final String AUTH_TEST_QUEUE="AUTH_TEST_QUEUE";

    /**
     * direct 交换机模式
     */
    @Bean
    public Queue queue(){
        return new Queue(AUTH_USER_QUEUE,true);
    }
}
