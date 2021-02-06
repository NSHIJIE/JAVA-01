package com.geek;

import java.util.concurrent.CompletableFuture;

public class DemoCompletableFuture {
    private static int result = 0;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        result = CompletableFuture.supplyAsync(()->Sum.sum()).join();
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        System.out.println("Main End...");
    }
}
