package com.zj.model;

/**
 * 包含同步方法的model
 * Created by LZJ on 2015/12/3.
 */
public class Money {


    /**
     * 当一个方法被声明为同步的时候,这个方法就会拥有一个锁,同一时刻只有拥有了该方法的锁的对象可以调用该方法,<br/>
     * 此为互斥锁
     */
    public synchronized void minus() {

    }


}
