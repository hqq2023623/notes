package com.zj.action.chapter08;

/**
 * LeftRightDeadlock,顺序死锁
 * <p>
 * Simple lock-ordering deadlock
 *
 * @author Brian Goetz and Tim Peierls
 */
public class LeftRightDeadlock {

    private final Object left = new Object();
    private final Object right = new Object();

    //锁住left的同时锁住right就造成了死锁
    public void leftRight() {
        synchronized (left) {
            synchronized (right) {
                doSomething();
            }
        }
    }

    public void rightLeft() {
        synchronized (right) {
            synchronized (left) {
                doSomethingElse();
            }
        }
    }

    void doSomething() {
    }

    void doSomethingElse() {
    }
}
