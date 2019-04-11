package com.study.factory.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 2.动态代理
 * 原理: 在程序运行期间根据需要动态创建代理类及其实例来完成具体的功能(本人理解就是程序在运行的时候,动态创建代理类为具体类实现功能的增强)
 * 分类:
 * JDK动态代理和CGLIB动态代理
 * 如下使用基于JDK实现的动态代理
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/3/27 15:44
 */
public class MyInvocationHandle implements InvocationHandler {

    private Object target;

    public MyInvocationHandle(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 调用方法 总结: 结婚使人成长
        System.out.println("gogogogogogogogogogo");
        Object val = method.invoke(target, args);
        System.out.println("这样多好,相互渗透的生活,有人说婚姻就像一个杯子,提供了一种容器,把男人和女人放在里面,相互渗透,为这苦涩的生活增添香味");

        return val;
    }
    public static void main(String[] args) {

        MyUservice targetObj = new MyUserviceImpl();
        MyInvocationHandle myHandler = new MyInvocationHandle(targetObj);

        //getInterfaces() 确定由该对象表示的类或接口实现的接口。要实现的代理类的接口列表
        System.out.println(" 获取的类是 : " + targetObj.getClass().getInterfaces()[0]);

        Class<MyUservice> clsService = (Class<MyUservice>) targetObj.getClass().getInterfaces()[0];
        System.out.println(clsService.toString());

        MyUservice realUservice = (MyUservice) Proxy.newProxyInstance(MyInvocationHandle.class.getClassLoader(),
                targetObj.getClass().getInterfaces(), myHandler);

        realUservice.select();

        String LOGIN_SMS="login_sms:%s:%s";
        String appName = "6";
        String phoneNum = "18589072284";
        String smsCodeRedisKey = String.format(LOGIN_SMS, appName, phoneNum);
        System.out.println(" 格式的值 : " + smsCodeRedisKey);









    }
}
