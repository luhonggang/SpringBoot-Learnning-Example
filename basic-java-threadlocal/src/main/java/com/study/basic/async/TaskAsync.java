package com.study.basic.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/2/26 18:11
 * SpringBoot 中异步调用
 */
@Component
public class TaskAsync {


    @Async
    public  void runTask01(){
        System.out.println("++++++++++ 任务01运行 ++++++++++");
    }

    @Async
    public  void runTask02(){
        System.out.println("++++++++++ 任务02运行 ++++++++++");
    }

    @Async
    public  void runTask03(){
        System.out.println("++++++++++ 任务03运行 ++++++++++");
    }
}
