package com.geek;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DemoLock {

    private static int result = 0;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread thread = new Thread(()->{
            lock.lock();
            result = Sum.sum();
            condition.signal();
            lock.unlock();
        });
        thread.start();
        lock.lock();
        condition.await();
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        System.out.println("Main End...");
    }
}
