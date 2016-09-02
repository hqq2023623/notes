package zj.sync.obj;

import zj.sync.SyncModel;

/**
 * 让model加1
 * Created by lzj on 2016/3/27.
 */
public class ThreadSyncA implements Runnable {

    private SyncModel model;

    public ThreadSyncA(SyncModel model) {
        this.model = model;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            model.syncA();
        }
    }


}
