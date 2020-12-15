package com.arbonkeep.concurrency03;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * @author arbonkeep
 * @date 2020/12/14 - 20:44
 */
public class MyTest02 {
    public static void main(String[] args) {
        //创建CyclicBarrier
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> {
            System.out.println("hhhhhhhhhhh");
        });
        //该参数代表线程数量，必须在障碍被释放之前调用await方法
        //创建3个线程
        for(int j = 0 ; j< 2; j++) {
            for (int i = 0; i < 4; i++) {
                new Thread(() -> {
                    try {
                        Thread.sleep((long) (Math.random() * 2000));
                        Random random = new Random();
                        int result = random.nextInt(500);
                        System.out.println("AAA" + result);
                        cyclicBarrier.await();
                        System.out.println("BBB" + result);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }

    }
}
