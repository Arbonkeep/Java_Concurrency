package com.arbonkeep.concurrency01.test01_wait_notify;

/**
 * @author arbonkeep
 * @date 2020/9/4 - 12:55
 * 增加的线程
 */
public class IncreaseThread extends Thread{
    private MyObject myObject;

    public IncreaseThread(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {
        //循环输出三十次
        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep( (long) Math.random() * 1000);//线程休眠一会，可以更清楚看清效果
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            myObject.increase();
        }

    }
}
