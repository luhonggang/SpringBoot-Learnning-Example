package com.study.factory;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/2/26 17:00
 */
public class TeacherWork implements Work {
    /**
     * 子类 TeacherWork 实现Work
     * 子类具体的 行为的定义
     */
    @Override
    public void doWork() {
        System.out.println("++++++++++ 老师在审批作业 ++++++++++");
    }
}
