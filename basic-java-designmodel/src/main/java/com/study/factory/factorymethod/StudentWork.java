package com.study.factory.factorymethod;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/2/26 17:01
 */
public class StudentWork implements Work {
    @Override
    public void doWork() {
        System.out.println("++++++++++ 学生在做作业 ++++++++++");
    }
}
