package zj.sync.helper.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源的多副本的并发访问控制
 *
 * @author Lzj Created on 2016/3/17.
 */
public class PrintQueue2 {

    private final Semaphore semaphore;
    //存放打印机的状态，true表示可用
    private boolean[] freePrinters;
    //保护对freePrinters数组的访问
    private Lock lockPrinters;

    public PrintQueue2() {
        semaphore = new Semaphore(3);
        freePrinters = new boolean[3];
        for (int i = 0; i < 3; i++) {
            freePrinters[i] = true;
        }
        lockPrinters = new ReentrantLock();
    }

    public void printJob(Object document) {
        try {
            semaphore.acquire();
            int assignedPrinter = getPrinter();
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + ":PrintQueue:Printing a Job during " + (duration / 1000) + "seconds");
            Thread.sleep(duration);
            //任务完成，把对应的printer置为空闲
            freePrinters[assignedPrinter] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放信号量
            semaphore.release();
        }
    }

    private int getPrinter() {
        //打印机编号
        int ret = -1;
        try {
            lockPrinters.lock();
            for (int i = 0; i < freePrinters.length; i++) {
                if (freePrinters[i]) {
                    ret = i;
                    freePrinters[i] = false;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockPrinters.unlock();
        }
        return ret;
    }


}
