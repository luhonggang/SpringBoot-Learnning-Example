package com.study.factory.factorymethod;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/2/26 16:59
 * 定义的工厂方法返回相应的Work类子类的 实例(此处 是返回 TeacherWork 实例)
 */
public class TeacherWorkFactory implements IworkFactory {
    /**
     * 获取到一个 老师类的实例
     * @return
     */
    @Override
    public Work getWork() {
        return new TeacherWork();
    }
}
