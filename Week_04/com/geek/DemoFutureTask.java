package com.geek;

import com.geek.future.FutureTask1;
import sun.awt.windows.ThemeReader;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class DemoFutureTask {

    private static int result = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(Sum::sum);

        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println("异步计算结果为："+futureTask.get());

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        System.out.println("Main End...");
    }
}
