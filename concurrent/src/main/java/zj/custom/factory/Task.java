package zj.custom.factory;

import java.util.concurrent.TimeUnit;

/**
 * @author Lzj Created on 2015/12/18.
 */
public class Task implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
