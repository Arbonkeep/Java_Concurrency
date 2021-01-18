package com.arbonkeep.concurrency05;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author arbonkeep
 * @date 2020/12/17 - 10:02
 */
public class MyTest02 {

    public static void main(String[] args) {
        //程序一：
        //此方法没有返回值
        String result = CompletableFuture.supplyAsync(() -> "hello")
                .thenApplyAsync(value -> value + "world").join();
        //此程序只是用于演示异步执行任务之后继续再执行一个一步任务
        System.out.println(result);

        //同时CompletableFuture还提供另一种不返回结果的分阶段执行的API
        String join = CompletableFuture.runAsync(() -> System.out.println("hello")).thenApplyAsync(value -> value + "AAA").join();
        System.out.println(join);
        //由于runAsync没有返回值，所以直接输出，在执行该任务后执行下一个任务所以为nullAAA
    }

    //程序二：可以对结果做消费处理，而不返回结果。
    @Test
    public void test01(){
        //thenAccept(Consumer<? super T> action),表示对结果的消费，没有返回值
        CompletableFuture.supplyAsync(() -> "小明")
                .thenAccept(value -> System.out.println(value + "真帅"));

    }

    //程序三：对多个CompletionStage的结果进行转换
    @Test
    public void test02() {
        //thenCombine()将两个CompletionStage进行合并，然后指定合并之后的行为
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "小花";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);//休眠
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "爱吃鱼";
            //定合并之后的行为,(r1, r2) -> r1 + "" + r2
        }), (r1, r2) -> r1 + "" + r2).join();

        System.out.println(result);
    }


    //whenComplete()当任务执行完会执行的动作
    @Test
    public void test03() {
        CompletableFuture <Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务正在执行。。。");
        });

        future.whenComplete((t, action) -> System.out.println("任务执行完成。。。"));

        System.out.println("主线程执行已完成。。。");

        try {
            TimeUnit.MILLISECONDS.sleep(7000);//线程阻塞，方便查看效果
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
