package com.arbonkeep.concurrency.test02_synchronized;

/**
 * @author arbonkeep
 * @date 2020/9/5 - 22:22
 */
public class TestThread2 {
    //思考哪个方法先输出
    public static void main(String[] args) {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();

        MyThread1 thread1 = new MyThread1(myClass1);
        MyThread2 thread2 = new MyThread2(myClass2);
        thread1.start();
        thread2.start();
        /*
         总结：
            如果是两个线程都使用myClass1来当作锁对象，那么就会先输出hello然后输出byebye，这是因为
            一个对象只有一把锁，当调用了sayHello后，又调用了sleep方法，sleep在等待期间是不会释放
            锁的，所以只有执行完sayHello才能执行sayBye
            如果线程使用不同的myClass对象来当作锁，那么就会先输出byebye然后输出hello，这是因为一
            个对象只有唯一的锁，而即使sleep占用了myClass1的锁，线程2使用的是myClass2的锁，所以在
            线程一休眠时，线程2会先执行完

         */

    }
}

class MyClass {
    public synchronized void sayHello() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("hello");
    }

    public synchronized void saybye() {
        System.out.println("byebye");
    }

}

class MyThread1 extends Thread{

    private MyClass myClass;

    public MyThread1(MyClass myClass) {
        this.myClass = myClass;
    }

    @Override
    public void run() {
        myClass.sayHello();
    }


}

class MyThread2 extends Thread {
    private MyClass myClass;

    public MyThread2(MyClass myClass) {
        this.myClass = myClass;
    }

    @Override
    public void run() {
        myClass.saybye();
    }
}
