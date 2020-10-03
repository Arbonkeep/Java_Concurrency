package com.arbonkeep.concurrency01.test03_synchronized;

/**
 * @author arbonkeep
 * @date 2020/9/8 - 12:14
 */
public class MyTest1 {
    Object object = new Object();

    public void method() {
        synchronized (object) {//在同步代码块中任何对象都可以作为锁（思考为什么）
            System.out.println("hello");
        }
    }

    public void method2() {
        synchronized (object) {
            System.out.println("world");
            throw new RuntimeException("出异常了");
        }

    }

/*
   在字节码层面，执行mythod方法时，通过javap反编译，我们可以发现有一个monitorenter两个monitorexit
   这是因为在method中有两种方式可能导致方法的结束，一种是正常结束，一种是抛异常。所需需要两个monitorexit
   来保证释放object对象的锁。而当我们执行method2方法时，会发现只有一个monitorenter和monitorexit，这是
   因为只能通过抛出异常结束方法，所以只有一个monitorexit
 */


}
