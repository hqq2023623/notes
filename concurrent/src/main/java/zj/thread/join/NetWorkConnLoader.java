package zj.thread.join;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Lzj Created on 2015/12/18.
 */
public class NetWorkConnLoader implements Runnable {


    @Override
    public void run() {
        System.out.println("network connecting ..." + new Date());
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("network connec has finished");
    }

}
