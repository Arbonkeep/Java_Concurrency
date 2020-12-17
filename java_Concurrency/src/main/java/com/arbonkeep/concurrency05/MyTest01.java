package com.arbonkeep.concurrency05;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author arbonkeep
 * @date 2020/12/16 - 21:21
 */
public class MyTest01 {

    public static void main(String[] args) {
        //需要有返回值
        Callable<Integer> callable = () -> {
            System.out.println("pre execution");
            //子线程休眠5秒
            Thread.sleep(5000);
            int result = new Random().nextInt(500);
            System.out.println("post execution");
            return  result;
        };

        //构建FutureTask
        FutureTask<Integer> futureTask = new FutureTask <>(callable);

        //创建一个线程执行任务,futureTask底层继承了Runnable所以可以直接当做参数传入
        new Thread(futureTask).start();
        System.out.println("thread has started");
        //获取执行结果
        try {
            //主线程休眠两秒
            Thread.sleep(2000);
            System.out.println("TaskResult: " + futureTask.get(3, TimeUnit.MILLISECONDS));;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
