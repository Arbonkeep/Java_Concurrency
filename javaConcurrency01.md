# java并发

## thread与Runnable详解

    1. 两者关系
        * Thread类实现了Runnable接口

    2. Thread类

        <1> jdk官方解释

<img src= "./img/img01.png" width= 800px>

<img src= "./img/img02.png" width= 800px>

        <2> 创建线程的方式
            1) 继承Thread类

            2) 实现Runnable接口


        <3> 线程优先级
            * 线程优先级
                默认优先级为5，最小优先级为1，最大优先级为10

<img src= "./img/img05.png" width= 800px>

        <4> start方法详解

<img src= "./img/img06.png" width= 800px>

    3. Runnable接口

        <1> 接口描述（函数式接口中只有一个抽象的run方法）

<img src= "./img/img03.png" width= 800px>

        <2> run方法描述

<img src= "./img/img04.png" width= 800px>

        
## wait与sleep的字节码分析

    1. wait方法详解

<img src= "./img/img07.png" width=800px>

        <1> 要点：
            1) 要想调用wait方法，当前线程必须拥有这个对象的锁

            2) 线程调用了wait方法之后就会释放掉对象的锁，进入等待状态，等待到另外的线程通知在这个对象的锁上等待的
               所有线程，唤醒方式通过notify或者notifyAll方法 

            3) 线程会继续执行直到它可以获取到一个monitor锁的拥有权，然后继续向下执行

        <2> 案例演示：MyTest1

    2. sleep方法详解

<img src= "./img/img08.png" width=800px>

    3. sleep与wait的区别
        <1> wait方法被调用后会失去线程锁的拥有权，而sleep方法不会失去线程锁的拥有权


## notify方法及线程获取锁的方式详解

    1. 首先我们对wait(long timeout)方法进行详解

<img src= "./img/img09.png" width=800px>

<img src= "./img/img10.png" width=800px>

<img src= "./img/img11.png" width=800px>

    2. notify与notifyAll

<img src= "./img/img12.png" width=800px>

## wait&notify&notifyAll的总结

    1. 当调用wait方法时，首先需要确保调用了wait方法的线程已经持有了对象的锁

    2. 当调用了wait方法时，线程会释放该对象的锁，从而进入等待状态(wait-set)

    3. 当线程调用了wait方法进入等待状态时，它可以通过其它线程调用相同对象的notify或者notifyAll方法来使得
       自己被唤醒

    4. 一旦这个线程被其他线程唤醒后，该线程就会与其他线程一起竞争该对象的锁（公平竞争）只有当该线程获取到
       了这个对象的锁后，线程才会继续往下执行

    5. 调用wait方法的代码片段需要方法一个synchronized代码块或者synchronized修饰的方法中，这样才可以确保
       线程在调用wait方法前就已经获取到了对象的锁

    6. 当调用对象的notify方法时，它会随机的唤醒该对象等待集合中的任意一个线程，当某个线程被唤醒后，它就会
       与其他线程一起竞争对象的锁

    7. 当调用对象的notifyAll方法时，它会唤醒该对象等待集合中所有的线程，线程被唤醒之后，会竞争对象的锁

    8. 在同一时刻，只有唯一一个线程可以拥有对象的锁

        