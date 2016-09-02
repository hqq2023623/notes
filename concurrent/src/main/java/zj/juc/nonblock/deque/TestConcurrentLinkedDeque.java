package zj.juc.nonblock.deque;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author Lzj Created on 2016/3/29.
 */
public class TestConcurrentLinkedDeque {


    public static void main(String[] args) {

        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
        Thread[] threads = new Thread[100];
        //启动创建线程
        for (int i = 0; i < threads.length; i++) {
            AddTask task = new AddTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }
        System.out.println("Main : " + threads.length + "  AddTask threads have been launched.");
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Main: Size of the List: " + list.size());
        //启动删除线程
        for (int i = 0; i < threads.length; i++) {
            PollTask task = new PollTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Main: Size of the List: " + list.size());

    }


}
