package zj.thread.group;

/**
 * Created by lzj on 2016/3/29.
 */
public class WriteThread implements Runnable {

    private BooleanHolder holder;

    public WriteThread(BooleanHolder holder) {
        this.holder = holder;
    }

    @Override
    public void run() {
        synchronized (holder) {
            while (!holder.flag) {
                try {
                    holder.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("I am write");
            holder.flag = false;
            holder.notifyAll();
        }
    }

}
