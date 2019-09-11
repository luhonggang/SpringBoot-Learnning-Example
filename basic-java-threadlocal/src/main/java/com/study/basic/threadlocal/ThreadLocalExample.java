package com.study.basic.threadlocal;

import lombok.extern.slf4j.Slf4j;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/1/29 15:01
 */
@Slf4j
public class ThreadLocalExample<T> {

    public static class MyRunnable implements Runnable {
        /**
         *  每个线程执行的时候 --> 都会创建该对象
         */
        private ThreadLocal<String>  threadLocal = new ThreadLocal<String>();
        @Override
        public void run() {
            threadLocal.set("你想干嘛 : "+(int)(Math.random() * 100));

            log.info("threadLocal 的引用地址 : " + threadLocal);

            log.info(" 当前线程获取 : "+Thread.currentThread().getName()+" 获取的值是 ====> "+threadLocal.get());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /**
         *  2个线程共享同一个MyRunnable 实例
         *  创建了两个线程共享一个MyRunnable实例。每个线程执行run()方法的时候，会给同一个ThreadLocal实例设置不同的值。
         *  如果调用set()方法的时候用synchronized关键字同步，而且不是一个ThreadLocal对象实例，那么第二个线程将会覆盖第一个线程所设置的值。
         *  然而，由于是ThreadLocal对象，所以两个线程无法看到彼此的值。因此，可以设置或者获取不同的值
         */
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);
        t1.start();
        t2.start();
        t1.join(); //等待线程1终止
        t2.join(); //等待线程2终止

        int num1 = 10;
        int num2 = 20;

        swap(num1, num2);

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(arr[0]);
        change(arr);
        System.out.println(arr[0]);


    }

//    public static void main(String[] args) {
//        int num1 = 10;
//        int num2 = 20;
//
//        swap(num1, num2);
//
//        System.out.println("num1 = " + num1);
//        System.out.println("num2 = " + num2);
//    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public static void change(int[] array) {
        // 将数组的第一个元素变为0
        array[0] = 0;
    }

}
