package zj.sync;

import java.util.concurrent.TimeUnit;

/**
 * 测试线程同步的共享资源
 * Created by lzj on 2016/3/27.
 */
public class SyncModel {
    //客户端加锁
    private int id;
    //自己加锁
    private int sync;

    //id加1操作
    public void add() {
        int temp = id;
        temp++;
        sleep();
        this.id = temp;
    }

    //id减1操作
    public void minus() {
        int temp = id;
        temp--;
        sleep();
        this.id = temp;
    }

    //临界区A
    public synchronized void syncA() {
        sleep();
        System.out.println(Thread.currentThread().getName());
        System.out.println("synchronized method");
    }

    //临界区B
    public void syncB() {
        synchronized (this) {
            sleep();
            System.out.println(Thread.currentThread().getName());
            System.out.println("synchronized(this)");
        }
    }

    //锁住类的临界区
    public synchronized static void statSync() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println("static synchronized");
    }

    //锁住指定类的所有对象
    public void syncClz() {
        sleep();
        synchronized (SyncModel.class) {
            System.out.println(Thread.currentThread().getName());
            System.out.println("synchronized (SyncModel.class)");
        }
    }

    //休眠100ms
    private void sleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

}
