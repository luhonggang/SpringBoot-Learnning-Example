package com.study.rabbitmq.exchange;

import com.study.rabbitmq.common.QueueUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/1/16 11:25
 */
@Component
@Slf4j
public class DirectExchangeReceiver {
    private static final String CHART_SET = "UTF-8";

    /**
     * 监听的queue
     * containerFactory="appFactory"
     * @param message
     */
    @RabbitListener(queues = QueueUtil.AUTH_USER_QUEUE,containerFactory="appFactory")
    public void receive(Message message) throws UnsupportedEncodingException {
        log.info(message.getBody()+"");
        if(null == message || null == message.getBody() || message.getBody().length < 1){
            log.info(" +++++++++++ message +++++++++++");
        }
        String msg = new String(message.getBody(),CHART_SET);
        log.info("receive msg : " + msg);
    }


}
