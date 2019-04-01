package com.study.factory.proxy.staticproxy;


/**
 * 1.静态代理
 * 原理:静态代理是指在程序运行前就已经存在的编译好的代理类是为静态代理
 * 步骤:
 * ①定义业务接口(IUserService)
 * ②被代理类实现业务接口(IUserServiceImpl)
 * ③定义代理类并实现业务接口(IUserServiceProxy)
 * ④最后便可通过客户端进行调用。（这里可以理解成程序的main方法里的内容）
 *
 * 此类 是一个代理类 实现程序在调用add()方法的时候
 * 动态地在add()方法前后打印日志功能
 *
 * 缺点:
 * ① 被代理类和代理类(IUserServiceProxy) 实现了相同的接口,导致代码重复,以致公共接口增加了一个方法,代理类和被代理类均要修改,增加代码的维护难度
 * ② 此种代理方式只能代理一个业务类,并不能针对多个类(比如某个包下的类)来进行代理,使用此种代理方式,也就导致需要写很多的代理类来代理
 * 针对如上问题 : 一种直观而又优雅的代理方式  动态代理于此产生了
 * 2.动态代理
 * 原理: 在程序运行期间根据需要动态创建代理类及其实例来完成具体的功能(本人理解就是程序在运行的时候,动态创建代理类为具体类实现功能的增强)
 * 分类:
 * JDK动态代理和CGLIB动态代理
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/3/27 15:20
 */
public class IUserServiceProxy implements IUserService{

    private IUserService iUserService;

    public IUserServiceProxy(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @Override
    public void add() {
        System.out.println("你为何对我贼眉鼠眼");
       iUserService.add();
        System.out.println("因为我对你爱得深沉");
    }


    public static void main(String[] args) {
        IUserService u = new IUserServiceImpl();
        IUserServiceProxy uproxy = new IUserServiceProxy(u);
        uproxy.add();
    }
}
