package zj.test.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * 模拟死锁的发生，两个线程互相在等待对方释放锁
 *
 * @author Lzj Created on 2016/3/23.
 */
public class TestDeadLock {

    public static void main(String[] args) {
        Object lockObj1 = new Object();
        Object lockObj2 = new Object();
        //分别启动两个线程
        Thread thread1 = new Thread(new DeadLock1(lockObj1, lockObj2));
        thread1.start();
        Thread thread2 = new Thread(new DeadLock2(lockObj1, lockObj2));
        thread2.start();
    }

}
