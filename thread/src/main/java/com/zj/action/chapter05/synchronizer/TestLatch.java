package com.zj.action.chapter05.synchronizer;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁的使用
 * Created by LZJ on 2015/12/8.
 */
public class TestLatch {

    //CountDownLatch是一个灵活的闭锁实现,允许一个或多个线程等待一个事件集的发生
    //闭锁的状态包括:
    //1.计数器,初始化为一个整数,表示需要等待的事件数
    //2.countDown()方法对计数器做减操作,表示一个事件已经发生
    //3.await()方法等待计数器为0,表示所有事件已经发生,如果计数器入口时数组非0
    //则会一直阻塞,直到为0或终端或超时

    public long timeTasks(int nThreads, final Runnable task)
            throws InterruptedException {
        //开始阀门,初始化为一,调用countDown()打开阀门
        final CountDownLatch startGate = new CountDownLatch(1);
        //结束阀门,初始化为线程数量
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        //建立一些线程
        //每个线程第一件要做的事是等待开始阀门打开:确保直到所有线程都准备好了才开始工作
        //开始阀门可让控制线程能够同时释放所有工作者线程
        //每个线程最后一件要做的事是为结束阀门减一
        //结束阀门让控制线程能够等待最后一个线程完成任务而不是顺序等待每一个线程结束
        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                public void run() {
                    try {
                        //为0才通过
                        startGate.await();
                        try {
                            //这里调用的是run()方法,而不是启动线程
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignored) {
                    }
                }
            };
            t.start();
        }

        long start = System.nanoTime();
        //打开开始阀门
        startGate.countDown();
        //等待结束阀门打开,让闭锁进入终点状态,让线程通过阀门开始工作
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {
        try {
            long time = new TestLatch().timeTasks(10, new PrintRunner());
            System.err.println("10个线程使用的时间 : " + time);
            time = new TestLatch().timeTasks(100, new PrintRunner());
            System.err.println("100个线程使用的时间 : " + time);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }


}
