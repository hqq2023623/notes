package zj.lock.reen;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Lzj Created on 2016/3/17.
 */
public class PrintQueue {

    private final Lock queueLock = new ReentrantLock();

    public void printJob(Object document) {
        //获取锁
        queueLock.lock();
        Long duration = (long) (Math.random() * 10000);
        System.out.println(Thread.currentThread().getName() + ":PrintQueue:Printing a Job during " + (duration / 1000) + "seconds");
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放锁
            queueLock.unlock();
        }
    }


}
