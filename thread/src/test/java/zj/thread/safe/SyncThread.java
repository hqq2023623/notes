package zj.thread.safe;

/**
 * 线程安全的
 *
 * @author Lzj Created on 2015/12/18.
 */
public class SyncThread implements Runnable {

    private User u;

    public SyncThread(User u) {
        this.u = u;
    }

    @Override
    public void run() {
//        u.addAndPrint();
//        u.printNext();
//        u.printAtomic();
        u.printPrivateLock();
    }


}
