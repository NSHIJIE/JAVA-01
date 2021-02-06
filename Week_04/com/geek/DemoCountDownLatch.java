package com.geek;

import java.util.concurrent.CountDownLatch;

public class DemoCountDownLatch {
    private static int result = 0;
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread thread = new Thread(()->{
            result = Sum.sum();
            countDownLatch.countDown();
        });
        thread.start();
        countDownLatch.await();
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        // 然后退出main线程
        System.out.println("Main End...");
    }
}
