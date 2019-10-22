package com.study.basic.lock;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * JDK 5中的锁是接口java.util.concurrent.locks.Lock。另外java.util.concurrent.locks.ReadWriteLock提供了一对可供读写并发的锁。根据前面的规则，我们从java.util.concurrent.locks.Lock的API开始。
 * void lock();
 * <p>
 * 获取锁。
 * <p>
 * 如果锁不可用，出于线程调度目的，将禁用当前线程，并且在获得锁之前，该线程将一直处于休眠状态。
 * <p>
 * void lockInterruptibly() throws InterruptedException;
 * <p>
 * 如果当前线程未被中断，则获取锁。
 * <p>
 * 如果锁可用，则获取锁，并立即返回。
 * <p>
 * 如果锁不可用，出于线程调度目的，将禁用当前线程，并且在发生以下两种情况之一以前，该线程将一直处于休眠状态：
 * <p>
 * 锁由当前线程获得；或者
 * 其他某个线程中断当前线程，并且支持对锁获取的中断。
 * 如果当前线程：
 * <p>
 * 在进入此方法时已经设置了该线程的中断状态；或者
 * 在获取锁时被中断，并且支持对锁获取的中断，
 * 则将抛出 InterruptedException，并清除当前线程的已中断状态。
 * Condition newCondition();
 * <p>
 * 返回绑定到此 Lock 实例的新 Condition 实例。下一小节中会重点谈Condition，此处不做过多的介绍。
 * <p>
 * boolean tryLock();
 * <p>
 * 仅在调用时锁为空闲状态才获取该锁。
 * <p>
 * 如果锁可用，则获取锁，并立即返回值 true。如果锁不可用，则此方法将立即返回值 false。
 * <p>
 * 通常对于那些不是必须获取锁的操作可能有用。
 * <p>
 * boolean tryLock(long time, TimeUnit unit) throws InterruptedException;
 * <p>
 * 如果锁在给定的等待时间内空闲，并且当前线程未被中断，则获取锁。
 * <p>
 * 如果锁可用，则此方法将立即返回值 true。如果锁不可用，出于线程调度目的，将禁用当前线程，并且在发生以下三种情况之一前，该线程将一直处于休眠状态：
 * <p>
 * 锁由当前线程获得；或者
 * 其他某个线程中断当前线程，并且支持对锁获取的中断；或者
 * 已超过指定的等待时间
 * 如果获得了锁，则返回值 true。
 * <p>
 * 如果当前线程：
 * <p>
 * 在进入此方法时已经设置了该线程的中断状态；或者
 * 在获取锁时被中断，并且支持对锁获取的中断，
 * 则将抛出 InterruptedException，并会清除当前线程的已中断状态。
 * 如果超过了指定的等待时间，则将返回值 false。如果 time 小于等于 0，该方法将完全不等待。
 * <p>
 * void unlock();
 * <p>
 * 释放锁。对应于lock()、tryLock()、tryLock(xx)、lockInterruptibly()等操作，如果成功的话应该对应着一个unlock()，这样可以避免死锁或者资源浪费。
 *
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/10/14 16:27
 */
public class AtomicIntegerWithLock {
    private int value;

    private Lock lock = new ReentrantLock();

    public AtomicIntegerWithLock() {
        super();
    }

    public AtomicIntegerWithLock(int value) {
        this.value = value;
    }

    public final int get() {
        lock.lock();
        try {
            return value;
        } finally {
            lock.unlock();
        }
    }

    public final void set(int newValue) {
        lock.lock();
        try {
            value = newValue;
        } finally {
            lock.unlock();
        }

    }

    public final int getAndSet(int newValue) {
        lock.lock();
        try {
            int ret = value;
            value = newValue;
            return ret;
        } finally {
            lock.unlock();
        }
    }

    public final boolean compareAndSet(int expect, int update) {
        lock.lock();
        try {
            if (value == expect) {
                value = update;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public final int getAndIncrement() {
        lock.lock();
        try {
            return value++;
        } finally {
            lock.unlock();
        }
    }

    public final int getAndDecrement() {
        lock.lock();
        try {
            return value--;
        } finally {
            lock.unlock();
        }
    }

    public final int incrementAndGet() {
        lock.lock();
        try {
            return ++value;
        } finally {
            lock.unlock();
        }
    }

    public final int decrementAndGet() {
        lock.lock();
        try {
            return --value;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return Integer.toString(get());
    }

    public static void main(String[] args) throws Exception{
        List<String> testList = new ArrayList<>(10);
        for (String s: testList
             ) {
            System.out.println("遍历开始");
        }
        ConcurrentHashMap map =new ConcurrentHashMap<>(12);
        Hashtable hashtable = new Hashtable(12);
        final int max = 10;
        final int loopCount = 100000;
        long costTime = 0;
        for (int m = 0; m < max; m++) {
            long start1 = System.nanoTime();
            final AtomicIntegerWithLock value1 = new AtomicIntegerWithLock(0);
            Thread[] ts = new Thread[max];
            for(int i=0;i<max;i++) {
                ts[i] = new Thread(() -> {
                    for (int i12 = 0; i12 < loopCount; i12++) {
                        value1.incrementAndGet();
                    }
                });
            }
            for(Thread t:ts) {
                t.start();
            }
            for(Thread t:ts) {
                t.join();
            }
            long end1 = System.nanoTime();
            costTime += (end1-start1);
        }
        System.out.println("cost1: " + (costTime));
        //
        System.out.println();
        costTime = 0;
        //
        final Object lock = new Object();
        for (int m = 0; m < max; m++) {
            staticValue=0;
            long start1 = System.nanoTime();
            Thread[] ts = new Thread[max];
            ts[0] = new Thread(() -> {
                for (int i1 = 0; i1 < loopCount; i1++) {
                    synchronized (lock) {
                        ++staticValue;
                    }
                }
            });
            ts[1] = new Thread(() -> {
                for (int i1 = 0; i1 < loopCount; i1++) {
                    synchronized (lock) {
                        ++staticValue;
                    }
                }
            });
            ts[2] = new Thread(() -> {
                for (int i1 = 0; i1 < loopCount; i1++) {
                    synchronized (lock) {
                        ++staticValue;
                    }
                }
            });
            ts[3] = new Thread(() -> {
                for (int i1 = 0; i1 < loopCount; i1++) {
                    synchronized (lock) {
                        ++staticValue;
                    }
                }
            });
            ts[4] = new Thread(() -> {
                for (int i1 = 0; i1 < loopCount; i1++) {
                    synchronized (lock) {
                        ++staticValue;
                    }
                }
            });
            ts[5] = new Thread(() -> {
                for (int i1 = 0; i1 < loopCount; i1++) {
                    synchronized (lock) {
                        ++staticValue;
                    }
                }
            });
            ts[6] = new Thread(() -> {
                for (int i1 = 0; i1 < loopCount; i1++) {
                    synchronized (lock) {
                        ++staticValue;
                    }
                }
            });
            ts[7] = new Thread(() -> {
                for (int i1 = 0; i1 < loopCount; i1++) {
                    synchronized (lock) {
                        ++staticValue;
                    }
                }
            });
            ts[8] = new Thread(() -> {
                for (int i1 = 0; i1 < loopCount; i1++) {
                    synchronized (lock) {
                        ++staticValue;
                    }
                }
            });
            ts[9] = new Thread(() -> {
                for (int i1 = 0; i1 < loopCount; i1++) {
                    synchronized (lock) {
                        ++staticValue;
                    }
                }
            });
            for(Thread t:ts) {
                t.start();
            }
            for(Thread t:ts) {
                t.join();
            }
            long end1 = System.nanoTime();
            costTime += (end1-start1);
        }
        //
        System.out.println("cost2: " + (costTime));
    }


    static int staticValue = 0;
}

