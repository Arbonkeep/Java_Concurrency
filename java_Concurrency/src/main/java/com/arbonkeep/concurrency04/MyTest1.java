package com.arbonkeep.concurrency04;

/**
 * @author arbonkeep
 * @date 2020/12/15 - 21:24
 */

public class MyTest1 {

    private int count;

    public synchronized int getCount() {
        return count;
    }
    //进行+1的操作
    public synchronized void increase() {
        this.count++;
    }

}