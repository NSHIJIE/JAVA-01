package com.geek;

import java.util.concurrent.Exchanger;

public class DemoExchanger {
    private static int result = 0;
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Exchanger<Integer> exchanger = new Exchanger<>();
        new Thread(() -> {
            try {
                exchanger.exchange(Sum.sum());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        result = exchanger.exchange(0);
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        System.out.println("Main End...");
    }
}
