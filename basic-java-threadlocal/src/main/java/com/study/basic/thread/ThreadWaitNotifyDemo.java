package com.study.basic.thread;

import java.util.LinkedList;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/2/18 9:57
 * 生产者与消费者模式代码模拟?
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        Basket basket = new Basket();
        Productor productor = new Productor("生产者",basket);
        Consumer consumer = new Consumer("消费者",basket);
        productor.start();
        consumer.start();

    }

}

/**
 * 消费者
 */
class Consumer extends Thread{
    private Basket basket;
    public Consumer(String name,Basket basket) {
        super(name);
        this.basket = basket;
    }

    @Override
    public void run() {
        basket.popApple();
    }
}

/**
 * 生产者
 */
class Productor extends Thread{
    private Basket basket;
    public Productor(String name,Basket basket) {
        super(name);
        this.basket = basket;
    }

    @Override
    public void run() {
        basket.pushApple();
    }
}

class Basket{
    private LinkedList<Apple> basket = new LinkedList<Apple>();

    /**
     * 向篮子中分批放入苹果 分4批
     */
    public synchronized void pushApple(){
        for (int i = 0; i < 20; i++) {
           Apple apple = new Apple(i);
           push(apple);
        }
    }

    /**
     * 取4批苹果
     */
    public synchronized void popApple(){
        for (int i = 0; i < 20; i++) {
            pop();
        }
    }

    /**
     * 向篮子里面放苹果
     * @param apple
     */
    private void push(Apple apple){
        if(basket.size() == 5){
            try {
                // 生产者一直往篮子里面放苹果,当篮子中苹果的数量为5的时候,此时就让当前线程释放锁,进入等待的状态,让消费者来消费
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            // 1秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        basket.addFirst(apple);
        System.out.println(Thread.currentThread().getName() + " 向篮子中放入苹果 : " + apple.toString());
        // 每次放了一个苹果就 通知消费者来消费 notify方法只唤醒一个等待（对象的）线程并使该线程开始执行
        notify();
    }

    /**
     * 向篮子里面放苹果
     */
    private void pop(){
        if(basket.size() == 0){
            try {
                // 消费者一直消费,发现篮子里面没有苹果的时候就等待生产者来生产
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            // 1秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Apple apple = basket.removeFirst();
        System.out.println(Thread.currentThread().getName()  +" 消费篮子中的苹果 : " + apple.toString() + " 篮子还剩 : " + basket.size());
        // 通知来生产
        notify();
    }
}
class Apple{
    private int i;

    public Apple(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "苹果 {" +
                "i=" + (i + 1)+
                '}';
    }
}
