package zj;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Lzj Created on 2016/3/23.
 */
public class TestDump {
    Object obj1 = new Object();
    Object obj2 = new Object();

    public void fun1() {
        synchronized (obj1) {
            fun2();
        }
    }


    public void fun2() {
        synchronized (obj2) {
            //让线程一直运行以便在控制台打印出堆栈信息 ctrl + break
            while (true) {
                System.out.print("");
            }
        }
    }

    public static void main(String[] args) {
        TestDump a = new TestDump();
        a.fun1();
    }

    void a() {
        Map<String, Object> map = new HashMap<>();
        Object o = new Object();
        map.put("o", o);
        //还需要从map中删除该引用才可以
        o = null;
    }

    //创建锁
    private Lock lock = new ReentrantLock();
    //创建关联条件
    private Condition isFull = lock.newCondition();
    private Condition isEmpty = lock.newCondition();
    private int size = 2;

    void get() {
        //获取锁
        lock.lock();
        try {
            //等待满足条件并接到唤醒通知
            while (size == 0) {
                isEmpty.await();
            }
            System.out.println("doGet when size == " + (size--));
            isEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.unlock();
        }
    }


    void set() {
        //获取锁
        lock.lock();
        try {
            //等待满足条件并接到唤醒通知
            while (size == 2) {
                isFull.await();
            }
            System.out.println("doSet when size == " + (size++));
            isFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.unlock();
        }
    }

}
