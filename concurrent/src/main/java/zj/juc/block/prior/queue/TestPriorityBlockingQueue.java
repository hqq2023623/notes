package zj.juc.block.prior.queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Lzj Created on 2016/4/1.
 */
public class TestPriorityBlockingQueue {

    public static void main(String[] args) {
        PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<>();
        Thread[] threads = new Thread[5];
        Task task;
        for (int i = 0; i < threads.length; i++) {
            task = new Task(i, queue);
            threads[i] = new Thread(task);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Main: Queue Size: " + queue.size());
        Event event;
        for (int i = 0; i < threads.length * 1000; i++) {
            event = queue.poll();
            System.out.println("Thread " + event.getThread() + "  Priority :  " + event.getPriority());
        }

        System.out.println("Main: Queue Size : " + queue.size());
        System.out.println("Main: End of this program.");


    }


}
