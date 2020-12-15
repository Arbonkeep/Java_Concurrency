package com.arbonkeep.concurrency03;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * @author arbonkeep
 * @date 2020/12/14 - 18:34
 */
public class MyTest01 {

    public static void main(String[] args) {
        //创建CountDownLatch
        //参数3，表示线程在调用wait()之前，必须调用countDown()的次数（3次）
        CountDownLatch latch = new CountDownLatch(3);
        //创建3个线程
        IntStream.range(0,3).forEach(i -> new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("111111");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                //调用countDown,latch必须要在finally中调用，确保出异常也能调用到
                latch.countDown();
            }
            System.out.println("aaa" + latch.getCount());

        }).start());
        //此刻子线程执行完毕
        System.out.println("子线程执行完毕啦。。。。");
        try {
            latch.await();
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完毕啦。。。。");
    }
}
