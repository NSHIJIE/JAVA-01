package com.geek;

import java.util.concurrent.locks.LockSupport;

public class DemoPark {
    private static int result = 0;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Thread t1 = Thread.currentThread();
        new Thread(() -> {
            result = Sum.sum();
            LockSupport.unpark(t1);
        }).start();

        LockSupport.park();
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        System.out.println("Main End...");
    }
}
