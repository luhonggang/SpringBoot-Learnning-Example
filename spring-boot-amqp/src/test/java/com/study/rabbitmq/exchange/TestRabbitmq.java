package com.study.rabbitmq.exchange;

import com.study.rabbitmq.common.QueueEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/1/16 16:32
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRabbitmq {
//    @Autowired
//    private Sender sender;
//
//    @Test
//    public void test(){
//
//        for (int i = 0; i < 3; i++) {
//            sender.send(i);
//        }
//    }

        @Resource(name = "appRabbitTemplate")
        AmqpTemplate appRabbitTemplate;
//
//        @Test
//        public void test002(){
//            String msg = " 测试消息发送开始 ";
//            appRabbitTemplate.convertAndSend(QueueEnum.AUTH_TEST_QUEUE.getExchange(),QueueEnum.AUTH_TEST_QUEUE.getRoutingKey(),msg);
//        }
}
