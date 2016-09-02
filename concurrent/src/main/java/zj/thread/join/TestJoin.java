package zj.thread.join;

import java.util.Date;

/**
 * @author Lzj Created on 2015/12/18.
 */
public class TestJoin {

    public static void main(String[] args) {

        Thread ds = new Thread(new DataSourceLoader());
        Thread nwc = new Thread(new NetWorkConnLoader());

        ds.start();
        nwc.start();
        //main线程将会等待ds和nwc执行完成才继续执行
        try {
            ds.join();
            nwc.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("configuration has been loaded : " + new Date());
    }


}
