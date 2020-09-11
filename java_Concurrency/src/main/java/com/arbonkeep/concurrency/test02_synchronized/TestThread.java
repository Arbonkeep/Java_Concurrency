package com.arbonkeep.concurrency.test02_synchronized;

/**
 * @author arbonkeep
 * @date 2020/9/5 - 15:12
 */
public class TestThread {
    /*

        多线程对象如果存在一个可以被修改的变量，那么对于多线程来讲是可以被共享的(所以多线程运行会导致结果不稳定)

     */

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
            new Thread(myThread).start();
            new Thread(myThread).start();
    }
}

class MyThread implements Runnable{
    private int x ;

    @Override
    public void run() {
        x = 0;
        while (true) {
            System.out.println("result:" + x++);

            try {
                Thread.sleep((long) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (x == 30) {
                break;
            }
        }
    }
}
