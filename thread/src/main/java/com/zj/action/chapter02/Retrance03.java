package com.zj.action.chapter02;

/**
 * 重进入：意味着锁的请求是基于"每线程"而不是"每调用"的<br/>
 * 具体实现为给每个锁分配一个请求计数和占有它的线程,当计数为0的时候可以认为锁没有被占有<br/>
 * 如果同一线程再次请求这个锁,计数将递增,每次线程退出同步块(monitorExit),计数递减,直到计数为0<br/>
 * <p>
 * <p>
 * Created by LZJ on 2015/12/7.
 */
public class Retrance03 {

}

class Widget {

    public synchronized void doSth() {
    }

}

class LongWidget extends Widget {

    @Override
    public synchronized void doSth() {
        System.out.println("Child doSth");
        //如果内部锁不可以重入,则super.doStn()的调用者永远无法得到锁,因为锁已经被LongWidget占用了
        super.doSth();
    }
}