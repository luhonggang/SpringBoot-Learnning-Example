package com.study.basic.thread;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/2/2 17:52
 */
public class ThreadCreateDemo {
    public static void main(String[] args) {

        Thread t;
        CountTask task = new CountTask();
        // 获取到处理器的个数
        int totalCoreNumber = Runtime.getRuntime().availableProcessors();

        System.out.println(" 处理器的个数totalCoreNumber : " + totalCoreNumber);
        // 接口的方式创建线程
        /**
         *  此处存在多个线程共享同一个Runnable 实例
         */
        for (int i = 0; i < 2 * totalCoreNumber; i++) {
            t = new Thread(task);
            t.start();
        }

        // 子类的方式创建线程
        for (int i = 0; i < 2 * totalCoreNumber; i++) {
            t = new CountThread();
            t.start();
        }


    }

    static class Counter{
        private int count = 0;
        public void increment(){
            count ++ ;
        }

        public int value(){
            return  count;
        }
    }

    static class CountTask implements Runnable{
        private  Counter counter =  new Counter();

        @Override
        public void run() {
            for (int i = 0; i < 100 ; i++) {
                doSomething();
                counter.increment();
            }
            System.out.println(" CountTask : " + counter.value());
        }

        private void doSomething() {
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    static class CountThread extends Thread{
        private  Counter counter =  new Counter();

        @Override
        public void run() {
            for (int i = 0; i < 100 ; i++) {
                doSomething();
                counter.increment();
            }
            System.out.println(" CountThread : " + counter.value());
        }

        private void doSomething() {
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
