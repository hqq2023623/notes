package zj.thread.safe.test;

import zj.thread.safe.SyncThread;
import zj.thread.safe.User;

/**
 * @author Lzj Created on 2015/12/18.
 */
public class TestUser {

    public static void main(String[] args) {
        User u = new User();
        for (int i = 0; i < 100; i++) {
            new Thread(new SyncThread(u)).start();
        }
    }


}
