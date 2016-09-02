package com.zj.base;

/**
 * 实现Runnable接口实现线程
 * Created by LZJ on 2015/12/3.
 */
public class RunnableThread implements Runnable {

    @Override
    public void run() {
        System.out.println("runnable therad" + Thread.currentThread().getId());
        System.err.println("runnable");
    }



}
