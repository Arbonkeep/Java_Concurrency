package com.arbonkeep.concurrency02;

/**
 * @author arbonkeep
 * @date 2020/9/28 - 23:16
 * 死锁测试
 */
public class MyTest1 {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            synchronized (lock2) {
                System.out.println("method1...invoked");
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            synchronized (lock1) {
                System.out.println("method2...invoked");
            }
        }
    }

    public static void main(String[] args) {
        final MyTest1 myTest1 = new MyTest1();

        Runnable runnable1 = () -> {
            while (true) {
                myTest1.method1();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread1 = new Thread(runnable1, "myThread1");

        Runnable runnable2 = () -> {
            while (true) {
                myTest1.method2();
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread2 = new Thread(runnable2, "myThread2");

        thread1.start();
        thread2.start();
    }


}
