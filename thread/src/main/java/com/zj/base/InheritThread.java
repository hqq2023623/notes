package com.zj.base;

/**
 * 继承java.lang.Thread类实现线程
 * Created by LZJ on 2015/12/3.
 */
public class InheritThread extends Thread {

    @Override
    public void run() {
        System.out.println("InheritThread run" + currentThread().getId());
        System.err.println("inherit");
    }
}
