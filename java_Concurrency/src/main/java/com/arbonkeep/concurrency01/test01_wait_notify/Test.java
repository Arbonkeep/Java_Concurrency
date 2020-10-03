package com.arbonkeep.concurrency01.test01_wait_notify;

/**
 * @author arbonkeep
 * @date 2020/9/4 - 13:13
 */
public class Test {
    /*
    编写一个多线程程序，实现这样的一个目标：

        1、存在一个对象，该对象有一个int类型的成员变量counter，该成员变量的初始值为0。
        2、创建两个线程，其中一个线程对该对象的成员变量counter增1，另一个线程对该对象的成员变量减1。
        3、输出该对象成员变量counter每次变化后的值。
        4、最终输出的结果应为：101010101010。。。。

        分析：
            1、声明一个类，定义counter+1与counter-1的方法
            2、创建两个线程类，在run方法中调用这两个方法
            3、声明一个main函数的方法进行调用

     */

    public static void main(String[] args) {
        MyObject myObject = new MyObject();

        DecreaseThread decreaseThread = new DecreaseThread(myObject);

        IncreaseThread increaseThread = new IncreaseThread(myObject);

        decreaseThread.start();
        increaseThread.start();

    }


}
