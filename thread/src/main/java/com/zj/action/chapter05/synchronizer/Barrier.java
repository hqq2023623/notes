package com.zj.action.chapter05.synchronizer;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 关卡类似于闭锁,它们都能够阻塞一组线程,直到某些事件发生<br/>
 * 关切与闭锁的不同点是所有线程必须同时到达关卡点,才能继续处理<br/>
 * 闭锁等待的是事件,关卡等待的是其他线程<br/>
 * 关卡实现的协议类似于约好集合的地点,等人到齐后再开始集体活动<br/>
 * 如果所有线程都到达了关卡点,会释放所有线程,之后关卡会重置以备下一次使用<br/>
 *
 * Created by LZJ on 2015/12/8.
 */
public class Barrier {

    //关卡通常用来模拟这样一个情况:一个步骤的计算可以并行完成,但是要求必须先完成所有与
    //某一个步骤相关的工作才可以进行下一步

    private final Board mainBoard;
    private final CyclicBarrier barrier;
    private final Worker[] workers;

    public Barrier(Board board) {
        this.mainBoard = board;
        int count = Runtime.getRuntime().availableProcessors();
        this.barrier = new CyclicBarrier(count,
                new Runnable() {
                    public void run() {
                        mainBoard.commitNewValues();
                    }
                });
        this.workers = new Worker[count];
        for (int i = 0; i < count; i++)
            workers[i] = new Worker(mainBoard.getSubBoard(count, i));
    }

    private class Worker implements Runnable {
        private final Board board;

        public Worker(Board board) {
            this.board = board;
        }

        public void run() {
            while (!board.hasConverged()) {
                for (int x = 0; x < board.getMaxX(); x++)
                    for (int y = 0; y < board.getMaxY(); y++)
                        board.setNewValue(x, y, computeValue(x, y));
                try {
                    barrier.await();
                } catch (InterruptedException ex) {
                    return;
                } catch (BrokenBarrierException ex) {
                    return;
                }
            }
        }

        private int computeValue(int x, int y) {
            // Compute the new value that goes in (x,y)
            return 0;
        }
    }

    public void start() {
        for (int i = 0; i < workers.length; i++)
            new Thread(workers[i]).start();
        mainBoard.waitForConvergence();
    }

    interface Board {
        int getMaxX();

        int getMaxY();

        int getValue(int x, int y);

        int setNewValue(int x, int y, int value);

        void commitNewValues();

        boolean hasConverged();

        void waitForConvergence();

        Board getSubBoard(int numPartitions, int index);
    }


}
