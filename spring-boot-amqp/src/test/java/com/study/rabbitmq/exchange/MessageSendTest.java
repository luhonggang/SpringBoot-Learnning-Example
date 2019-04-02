//package com.study.rabbitmq.exchange;
//
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.assertTrue;
//
///**
// * @SpringBootTest(classes = RabbitMqApplication.class)
// * @author luhonggang
// * @version 1.8.0
// * @date 2019/1/16 13:50
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Slf4j
//@SuppressWarnings("all")
//public class MessageSendTest {
//
//    @Autowired
//    DirectExchangeSender sender;
//
//
//    @Test
//    public void testMq(){
//        sender.send(" 测试MQ发送消息给到消费端,为什么会获取不到消息,这是个问题,因为@Primaryz注解? ");
//    }
//
//
//    /**
//     * Rigorous Test :-)
//     */
//    @Test
//    public void shouldAnswerWithTrue()
//    {
//        assertTrue( true );
//    }
//}