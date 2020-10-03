package com.arbonkeep.concurrency01.test03_synchronized;

/**
 * @author arbonkeep
 * @date 2020/9/28 - 12:56
 */
public class MyTest5 {
    private Object object = new Object();

    public void method() {
        //Object object = new Object();

        synchronized (object) {
            System.out.println("hello");
        }

        synchronized (object) {
            System.out.println("nihao");
        }

        synchronized (object) {
            System.out.println("你好");
        }
    }
}
