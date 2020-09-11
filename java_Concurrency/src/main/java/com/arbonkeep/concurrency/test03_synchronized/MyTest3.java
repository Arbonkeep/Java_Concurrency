package com.arbonkeep.concurrency.test03_synchronized;

/**
 * @author arbonkeep
 * @date 2020/9/10 - 16:14
 */
public class MyTest3 {

    public synchronized static void method() {
        System.out.println("hello");
    }
}
