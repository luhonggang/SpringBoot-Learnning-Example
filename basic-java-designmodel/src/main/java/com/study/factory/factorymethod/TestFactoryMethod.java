package com.study.factory.factorymethod;

/**
 * 工厂方法 测试类
 * 工厂方法 :
 * 定义一个用于创建对象的接口，让子类决定实例化哪一个类。FactoryMethod使一个类的实例化延迟到其子类。
 * 适用性:
 *  1.当一个类不知道它所必须创建的对象的类的时候。
 *  2.当一个类希望由它的子类来指定它所创建的对象的时候。
 *  3.当类将创建对象的职责委托给多个帮助子类中的某一个，并且你希望将哪一个帮助子类是代理者这一信息局部化的时候。
 *
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/2/26 17:04
 */
public class TestFactoryMethod {
    public static void main(String[] args) {

        IworkFactory teacherFactory = new TeacherWorkFactory();
        teacherFactory.getWork().doWork();


        IworkFactory studentFactory = new StudentWorkFactory();
        studentFactory.getWork().doWork();

    }
}
