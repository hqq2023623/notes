package zj.test.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * @author Lzj Created on 2016/3/23.
 */
public class DeadLock1 implements Runnable {

    private Object o1, o2;

    public DeadLock1(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        fun();
    }

    public void fun() {
        //获取o1的monitor
        synchronized (o1) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //获取o2的monitor
            synchronized (o2) {

            }
        }
    }

}
