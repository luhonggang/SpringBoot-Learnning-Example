package com.study.rabbitmq.common;

/**
 * 申明队列枚举类
 */
public enum QueueEnum{

    /**
     * 测试队列
     */
    AUTH_USER_QUEUE("AUTH_USER_QUEUE", "AUTH_USER_EXCHANGE", "AUTH_USER_QUEUE"),

    AUTH_TEST_QUEUE("AUTH_TEST_QUEUE", "AUTH_TEST_EXCHANGE", "AUTH_TEST_ROUTING");


    private String queue;
    private String exchange;
    private String routingKey;

    QueueEnum(String queue, String exchange, String routingKey){
        this.queue = queue;
        this.exchange = exchange;
        this.routingKey = routingKey;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }
}
