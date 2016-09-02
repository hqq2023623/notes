package zj.sync.obj;

import zj.sync.SyncModel;

/**
 * 让model加1
 * Created by lzj on 2016/3/27.
 */
public class ThreadSyncB implements Runnable {

    private SyncModel model;

    public ThreadSyncB(SyncModel model) {
        this.model = model;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            model.syncB();
        }
    }


}
