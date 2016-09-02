package zj.sync.obj;

import zj.sync.SyncModel;

/**
 * Created by lzj on 2016/3/27.
 */
public class TestObj {

    public static void main(String[] args) {
        SyncModel model = new SyncModel();
        Thread add = new Thread(new ThreadAdd(model), "Thread add");
        Thread minus = new Thread(new ThreadAdd(model), "Thread minus");

        add.start();
        minus.start();

        try {
            add.join();
            minus.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("final : " + model.getId());


    }


}
