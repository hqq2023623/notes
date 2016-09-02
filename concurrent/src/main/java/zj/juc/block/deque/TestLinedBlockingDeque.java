package zj.juc.block.deque;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @author Lzj Created on 2016/3/29.
 */
public class TestLinedBlockingDeque {

    public static void main(String[] args) {

        LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>(3);
        Client client = new Client(list);
        Thread thread = new Thread(client);
        thread.start();

        //使用list对象的take()方法，每300ms从列表中取出3个字符串对象，重复5次
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                try {
                    String request = list.take();
                    System.out.println("Main: Request: " + request + "  at : " + new Date() + "    Size: " + list.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Main: End of this program.");
    }


}
