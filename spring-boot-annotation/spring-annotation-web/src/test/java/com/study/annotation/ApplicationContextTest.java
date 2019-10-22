package com.study.annotation;

import com.study.annotation.applicationcontextaware.SpringContextUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationContextTest
{

    @Autowired
    SpringContextUtil springContextUtil;
    /**
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
        System.out.println("测试类型" + springContextUtil.getBean("helloController"));
    }
}
