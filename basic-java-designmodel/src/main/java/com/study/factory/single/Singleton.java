package com.study.factory.single;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/2/27 10:50
 * 单例
 */
public class Singleton {

    private static Singleton singleton;

    private Singleton(){ }

    public static Singleton getInstance(){
        synchronized (Singleton.class){
            if (singleton == null){
                singleton = new Singleton();
            }
        }
        return singleton;
    }

    public static final int count = 4;

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println("引用地址equals对比的结果 : " + s1.equals(s2));
        System.out.println("引用地址等值对比的结果 : " + (s1 == s2));

        Runnable r1 = new MyThread("t1");
        Runnable r2 = new MyThread02("t2");

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();

        Runnable r3 = new MyThread("t3");
        Runnable r4 = new MyThread02("t4");

        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);
        t3.start();
        t4.start();
    }

}

class MyThread implements Runnable{
    private String myName;

    public MyThread(String myName) {
        this.myName = myName;
    }

    @Override
    public void  run(){
        for (int i = 0; i < Singleton.count; i++) {
            Singleton s = Singleton.getInstance();
            System.out.println("线程名称 : " + Thread.currentThread().getName()+" 对象的引用地址 : " + s );
        }
    }
}

class MyThread02 implements Runnable{
    private String myName;

    public MyThread02(String myName) {
        this.myName = myName;
    }

    @Override
    public void  run(){
        for (int i = 0; i < Singleton.count; i++) {
            Singleton s = Singleton.getInstance();
            System.out.println("线程名称 : " + Thread.currentThread().getName()+" 对象的引用地址 : " + s );
        }
    }
}

class MyThread03 implements Runnable{
    private String myName;

    public MyThread03(String myName) {
        this.myName = myName;
    }

    @Override
    public void  run(){
        for (int i = 0; i < Singleton.count; i++) {
            Singleton s = Singleton.getInstance();
            System.out.println("线程名称 : " + Thread.currentThread().getName()+" 对象的引用地址 : " + s );
        }
    }
}

class MyThread04 implements Runnable{
    private String myName;

    public MyThread04(String myName) {
        this.myName = myName;
    }

    @Override
    public void  run(){
        for (int i = 0; i < Singleton.count; i++) {
            Singleton s = Singleton.getInstance();
            System.out.println("线程名称 : " + Thread.currentThread().getName()+" 对象的引用地址 : " + s );
        }
    }
}


