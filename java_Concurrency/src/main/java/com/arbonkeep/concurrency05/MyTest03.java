package com.arbonkeep.concurrency05;

import org.junit.jupiter.api.Test;

/**
 * @author arbonkeep
 * @date 2020/12/17 - 17:09
 */
public class MyTest03 {

    private static ThreadLocal<String> threadLocal = new ThreadLocal <>();

    public static void main(String[] args) {
        //设置值
        threadLocal.set("123");
        //获取值
        String s = threadLocal.get();
        System.out.println(s);
        //再次设置
        threadLocal.set("456");//在次设置会进行覆盖
        System.out.println(threadLocal.get());


    }
}
