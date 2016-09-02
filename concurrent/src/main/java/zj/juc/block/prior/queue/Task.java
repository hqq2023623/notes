package zj.juc.block.prior.queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Lzj Created on 2016/4/1.
 */
public class Task implements Runnable {

    private int id;

    private PriorityBlockingQueue<Event> queue;

    public Task(int id, PriorityBlockingQueue<Event> queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        Event event;
        for (int i = 0; i < 1000; i++) {
            event = new Event(id, i);
            queue.add(event);
        }
    }


}
