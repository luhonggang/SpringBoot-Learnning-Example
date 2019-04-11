package com.study.factory.factorymethod;

/**
 * 该类主要负责定义其子类的实例化对象的方式
 * 通过调用方法来初始化其子类的实例
 */
public interface IworkFactory {
    /**
     * 获取Work 类的一个子类的实现的方法
     * @return
     */
    Work getWork();
}
