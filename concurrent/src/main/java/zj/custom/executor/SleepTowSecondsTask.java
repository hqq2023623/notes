package zj.custom.executor;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author Lzj Created on 2016/3/21.
 */
public class SleepTowSecondsTask implements Callable<String> {


    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        return new Date().toString();
    }


}
