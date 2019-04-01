package com.study.factory.proxy.dynamicproxy;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/3/27 15:49
 */
public class MyUserviceImpl implements MyUservice{
    @Override
    public void select() {
        System.out.println("我多想探探你的秘密");
    }
}
