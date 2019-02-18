package com.study.basic.thread;

import org.springframework.util.StringUtils;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/2/15 11:50
 */
public class ThreadDemo  {

    public static void main(String[] args) {
        Thread t1 = new MyThread("t1");
        Thread t2 = new MyThread("t2");
        t1.start();
        t2.start();
    }
    static class MyThread extends Thread{
        private static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(()->{
            return "123";
        });
        public MyThread(String name){
            super(name);
        }

        public void run(){
//            if(StringUtils.isEmpty(threadLocal.get())){
                threadLocal.set(Thread.currentThread().getName());
//            }
            System.out.println("线程 " + Thread.currentThread().getName() +" 存储的值是 : "+threadLocal.get());
        }
    }
}
