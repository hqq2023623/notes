package zj.juc.random;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Lzj Created on 2016/4/1.
 */
public class TaskLocalRandom implements Runnable {

    public TaskLocalRandom() {
        ThreadLocalRandom.current();
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "  " + ThreadLocalRandom.current().nextInt(10));
        }
    }


    public static void main(String[] args) {

        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            TaskLocalRandom task = new TaskLocalRandom();
            threads[i] = new Thread(task);
            threads[i].start();
        }

    }


}
