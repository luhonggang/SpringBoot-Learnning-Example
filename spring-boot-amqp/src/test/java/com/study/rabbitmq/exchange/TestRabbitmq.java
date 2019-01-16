package com.study.rabbitmq.exchange;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/1/16 16:32
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRabbitmq {
    @Autowired
    private Sender sender;

    @Test
    public void test(){

        for (int i = 0; i < 3; i++) {
            sender.send(i);
        }
    }
}
