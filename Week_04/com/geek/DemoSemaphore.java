package com.geek;

import java.util.concurrent.Semaphore;

public class DemoSemaphore {

    private static int result = 0;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Semaphore sp = new Semaphore(0);

        new Thread(()->{
            result = Sum.sum();
            sp.release();
        }).start();
        sp.acquire();
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        System.out.println("Main End...");
    }
}
