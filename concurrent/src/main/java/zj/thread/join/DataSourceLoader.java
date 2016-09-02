package zj.thread.join;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Lzj Created on 2015/12/18.
 */
public class DataSourceLoader implements Runnable {


    @Override
    public void run() {
        System.out.println("begin datasource loading ..." + new Date());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("datasource loading has finished");
    }

}
