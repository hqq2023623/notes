package zj.sync.clz;

import zj.sync.SyncModel;
import zj.sync.obj.ThreadAdd;

/**
 * Created by lzj on 2016/3/27.
 */
public class TestClz {

    public static void main(String[] args) {
        SyncModel model = new SyncModel();
        Thread add = new Thread(new SyncClz(model), "Thread clz");
        Thread minus = new Thread(new SyncStat(model), "Thread static");

        add.start();
        minus.start();


    }


}
