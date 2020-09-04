package com.arbonkeep.concurrency.test01;

/**
 * @author arbonkeep
 * @date 2020/9/4 - 13:06
 */
public class DecreaseThread extends Thread {
    private MyObject myObject;

    public DecreaseThread(MyObject object) {
        this.myObject = object;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep((long) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            myObject.decrease();

        }
    }
}
