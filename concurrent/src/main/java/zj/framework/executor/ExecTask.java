package zj.framework.executor;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Lzj Created on 2016/3/17.
 */
public class ExecTask implements Runnable {

    private Date initDate;

    private String name;

    public ExecTask(String name) {
        initDate = new Date();
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Task :" + name + "  created on:" + initDate);
        Long duration = (long) (Math.random() * 10);
        System.out.println(Thread.currentThread().getName() + ": doing a task during :" + duration + " seconds.");
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "  ");
    }


}
