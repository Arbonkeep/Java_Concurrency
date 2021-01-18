package com.arbonkeep.concurrency05;

/**
 * @author arbonkeep
 * @date 2020/12/17 - 17:32
 *  此程序说明ThreadLocal 可以为每个线程创建一个单独的变量副本，其它线程不能共享
 */
public class ThreadLocalTest {
    private static String strLabel;
    private static ThreadLocal<String> threadLabel = new ThreadLocal<>();

    public static void main(String... args) {
        strLabel = "main";
        threadLabel.set("main");
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                strLabel = "child";
                threadLabel.set("child");
                System.out.println("threadLabel = " + threadLabel.get());
            }
        };
        thread.start();
        try {
            // 保证线程执行完毕
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("strLabel = " + strLabel);
        System.out.println("threadLabel = " + threadLabel.get());
    }
}