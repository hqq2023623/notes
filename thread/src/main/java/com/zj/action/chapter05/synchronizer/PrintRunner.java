package com.zj.action.chapter05.synchronizer;

/**
 * Created by LZJ on 2015/12/8.
 */
public class PrintRunner implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
