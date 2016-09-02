package zj.thread.consumer_producer;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Lzj Created on 2016/3/17.
 */
public class EventStorage {

    //缓冲区数据的最大值
    private int maxSize;
    //缓冲区
    private List<Date> storage;

    public EventStorage() {
        maxSize = 10;
        storage = new LinkedList<>();
    }

    //生产方法
    public synchronized void set() {
        //如果已满就挂起线程
        while (storage.size() == maxSize) {
            try {
                System.out.println("producer wait");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.println("Set : " + storage.size());
        //通知等待的线程消费者线程
        notifyAll();
    }

    //消费方法
    public synchronized void get() {
        //如果没有库存就挂起线程
        while (storage.size() == 0) {
            try {
                System.out.println("consumer wait");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ((LinkedList<?>) storage).poll();
        System.out.println("Get : " + storage.size());
        //通知阻塞的线程生产者线程
        notifyAll();
    }


}
