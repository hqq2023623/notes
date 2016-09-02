package zj.thread.base;

import javax.sound.midi.Soundbank;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by lzj on 2016/3/26.
 */
public class FileLock implements Runnable {
    //打印一次日期休眠1s
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Date());
            try {
                //挂起线程1s
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException("currentThread is interrupted");
            }
        }
    }

    public static void main(String[] args) {
        FileLock fl = new FileLock();
        Thread t = new Thread(fl);
        t.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //中断fl线程
        t.interrupt();
    }
}
