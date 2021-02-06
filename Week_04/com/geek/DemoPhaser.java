package com.geek;

import java.util.concurrent.Phaser;

public class DemoPhaser {
    private static int result = 0;
    public static void main(String[] args) {
            long start=System.currentTimeMillis();
            Phaser phaser = new Phaser(1);
            phaser.register();
            new Thread(() -> {
                result = Sum.sum();
                phaser.arriveAndAwaitAdvance();
            }).start();
            phaser.arriveAndAwaitAdvance();
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        System.out.println("Main End...");
    }
}
