package zj.juc.block.deque;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @author Lzj Created on 2016/3/29.
 */
public class Client implements Runnable {

    private LinkedBlockingDeque<String> list;

    public Client(LinkedBlockingDeque<String> list) {
        this.list = list;
    }

    //使用list的put()方法，每两秒向list中插入5个字符串，重复3次
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                StringBuilder str = new StringBuilder();
                str.append(i).append(":").append(j);
                try {
                    list.put(str.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Client: " + list + "  at  " + new Date());
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Client : End.");

    }


}
