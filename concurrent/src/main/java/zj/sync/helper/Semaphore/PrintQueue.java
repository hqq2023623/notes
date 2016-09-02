package zj.sync.helper.Semaphore;

import java.util.concurrent.Semaphore;

/**
 * 使用信号量控制每次只能有一个线程可以执行打印操作
 *
 * @author Lzj Created on 2016/3/17.
 */
public class PrintQueue {

    private final Semaphore semaphore;

    public PrintQueue() {
        semaphore = new Semaphore(1);
    }

    public void printJob(Object document) {
        try {
            semaphore.acquire();
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + ":PrintQueue:Printing a Job during " + (duration / 1000) + "seconds");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放信号量
            semaphore.release();
        }
    }


}
