package com.arbonkeep.concurrency02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author arbonkeep
 * @date 2020/10/3 - 15:33
 * 可重入锁
 */
public class MyTest2 {
    private ReentrantLock lock = new ReentrantLock();//可重入锁

    public void method1() {
        try {
            lock.lock();//获取锁
            System.out.println("method1 invoked");
        }finally {
            //lock.unlock();//释放锁
        }
    }

    public void method2() {
//        try {
//            lock.lock();
//            System.out.println("method2 invoked");
//        }finally {
//            lock.unlock();
//        }

        boolean result = false;
        try {
             result = lock.tryLock(800, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (result) {
            System.out.println("get the lock");
        }else {
            System.out.println("can not get the lock");
        }

    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();

        Thread thread1 = new Thread(()-> {
            for (int i = 0; i < 10; ++i) {
                myTest2.method1();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; ++i) {
                myTest2.method2();
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        thread1.start();
        thread2.start();
    }
}
