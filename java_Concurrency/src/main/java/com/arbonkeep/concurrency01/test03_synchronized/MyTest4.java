package com.arbonkeep.concurrency01.test03_synchronized;

/**
 * @author arbonkeep
 * @date 2020/9/28 - 10:02
 */
public class MyTest4 {
    /**
     * 当object对象作为成员变量时，那么每个线程来访问时，每个线程获取的object锁对象都是同一个
     * 当Object对象作为局部变量时，那么每个线程访问方法时，获取的锁对象都是不同的
     */

//    private Object object = new Object();

    public void method() {

        Object object = new Object();

        //同步代码块
        synchronized (object) {
            System.out.println("hello");
        }
    }
}
