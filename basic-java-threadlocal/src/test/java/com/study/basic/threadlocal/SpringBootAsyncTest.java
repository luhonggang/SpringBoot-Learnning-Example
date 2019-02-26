package com.study.basic.threadlocal;

import com.study.basic.async.TaskAsync;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/2/26 21:27
 */
@Component
public class SpringBootAsyncTest extends BasicJavaThreadlocalApplicationTests{


    @Autowired
    TaskAsync taskAsync;

    /**
     * 异步调用顺序测试
     */
    @Test
    public void  testAsync(){

        taskAsync.runTask01();
        taskAsync.runTask02();
        taskAsync.runTask03();

    }
}
