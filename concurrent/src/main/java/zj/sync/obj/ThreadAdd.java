package zj.sync.obj;

import zj.sync.SyncModel;

/**
 * 让model加1
 * Created by lzj on 2016/3/27.
 */
public class ThreadAdd implements Runnable {

    private SyncModel model;

    public ThreadAdd(SyncModel model) {
        this.model = model;
    }

    @Override
    public void run() {
        synchronized (model) {
            //id加10
            for (int i = 0; i < 10; i++) {
                model.add();
            }
        }
    }


}
