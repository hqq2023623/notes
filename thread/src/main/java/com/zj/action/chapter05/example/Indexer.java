package com.zj.action.chapter05.example;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * 建立索引(消费者)
 * Created by LZJ on 2015/12/8.
 */
public class Indexer implements Runnable {

    private final BlockingQueue<File> queue;

    public Indexer(BlockingQueue<File> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        while (true) {
            try {
                indexFile(queue.take());
            } catch (InterruptedException e) {
                //当一个方法能够抛出InterruptedException时,表明这个是一个可阻塞方法
                //进一步看,如果它被中断,将可以提前结束阻塞状态
                //当调用了可以抛出该异常的方法时,你自己的方法也成了阻塞方法
                //两种处理方式:
                //1.传递,抛给调用者
                //2.恢复中断,调用 Thread.currentThread().interrupt();
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    private void indexFile(File f) {
        System.out.println("Index a new file");
    }
}
