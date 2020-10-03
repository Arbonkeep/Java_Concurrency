package com.arbonkeep.concurrency01.test01_wait_notify;

/**
 * @author arbonkeep
 * @date 2020/9/4 - 12:04
 */
public class MyObject {


    private int counter;

    //声明增加的方法
    public synchronized void increase() {
        //如果counter是大于0的那么就需要进行--操作，就让线程进入休眠
        if (counter != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        counter++;

        System.out.println(counter);

        notify();//调用notify唤醒等待队列线程
    }


    //声明减少的方法
    public synchronized void decrease() {
        //如果等于0的话，那么就需要进入休眠状态
        if (counter == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        counter--;

        System.out.println(counter);

        notify();
    }

}
