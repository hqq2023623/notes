package zj.juc.nonblock.deque;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author Lzj Created on 2016/3/29.
 */
public class PollTask implements Runnable {

    private ConcurrentLinkedDeque<String> list;

    public PollTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            list.pollFirst();
            list.pollLast();
        }
    }


}
