package com.geek;

import java.util.concurrent.Callable;

public class DemoCallable {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        Callable<Integer> result = Sum::sum;
        System.out.println("异步计算结果为："+result.call());

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        System.out.println("Main End...");
    }
}
