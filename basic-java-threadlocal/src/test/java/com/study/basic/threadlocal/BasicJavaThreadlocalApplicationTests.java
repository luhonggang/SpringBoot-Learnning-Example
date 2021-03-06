package com.study.basic.threadlocal;

import com.study.basic.async.TaskAsync;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicJavaThreadlocalApplicationTests {

    @Autowired
    TaskAsync taskAsync;


    @Test
    public void contextLoads() {
        taskAsync.runTask01();
        taskAsync.runTask02();
        taskAsync.runTask03();
    }

}

