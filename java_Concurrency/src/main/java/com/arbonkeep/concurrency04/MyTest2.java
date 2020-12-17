package com.arbonkeep.concurrency04;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author arbonkeep
 * @date 2020/12/16 - 12:05
 */
public class MyTest2 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(3);

        System.out.println(atomicInteger.get());//将值获取出来
        System.out.println(atomicInteger.getAndIncrement());//将值获取出来并进行+1，此时返回的是原来没有自增的结果
        System.out.println(atomicInteger.getAndSet(6));//此时获取的是旧的值，并将该值设置为6
        System.out.println(atomicInteger.get());//此时获取的值为6
    }
}
