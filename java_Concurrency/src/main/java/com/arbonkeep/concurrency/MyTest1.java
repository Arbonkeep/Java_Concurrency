package com.arbonkeep.concurrency;

/**
 * @author arbonkeep
 * @date 2020/8/31 - 12:02
 */
public class MyTest1 {

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();

        //obj.wait();//执行失败IllegalMonitorStateException，因为调用wait方法必须要在拥有锁的情况下
        synchronized (obj) {//为对象上锁
            obj.wait();
        }

    }
}
