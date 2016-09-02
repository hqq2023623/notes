package zj.sync.helper.Semaphore;

/**
 * @author Lzj Created on 2016/3/17.
 */
public class TestSemaphore {

    public static void main(String[] args) {

        PrintQueue printQueue = new PrintQueue();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job(printQueue), "Thread " + i);
        }

        //启动这10个线程
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }



}
