package com.study.factory;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/2/26 17:03
 * 定义的工厂方法返回相应的Work类子类的 实例(此处 是返回StudentWork实例)
 */
public class StudentWorkFactory implements IworkFactory {
    @Override
    public Work getWork() {
        return new StudentWork();
    }
}
