package zj.sync.obj;

import zj.sync.SyncModel;

/**
 * Created by lzj on 2016/3/27.
 */
public class TestSync {

    public static void main(String[] args) {
        SyncModel model = new SyncModel();
        Thread add = new Thread(new ThreadSyncA(model), "Thread A");
        Thread minus = new Thread(new ThreadSyncB(model), "Thread B");

        add.start();
        minus.start();

    }


}
