package zj.sync.clz;

import zj.sync.SyncModel;

/**
 * Created by lzj on 2016/3/27.
 */
public class SyncStat implements Runnable {

    private SyncModel model;

    public SyncStat(SyncModel model) {
        this.model = model;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            model.statSync();
        }
    }
}
