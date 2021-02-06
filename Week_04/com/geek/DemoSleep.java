package com.geek;

public class DemoSleep {
    public static int result = 0;
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(() ->{
            result = Sum.sum();
        });
        t1.start();
        Thread.sleep(500);
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        // 然后退出main线程
        System.out.println("Main End...");
    }
}
