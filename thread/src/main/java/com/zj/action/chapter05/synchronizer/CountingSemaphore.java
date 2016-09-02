package com.zj.action.chapter05.synchronizer;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * 信号量:用来控制能够同时访问某特定资源的活动的数量,或者同时执行某个同一操作的数量<br/>
 * 可以用来实现资源池或者一个容器的边界<br/>
 * 一个信号量管理一个许可集(permit),初始的数量由构造函数给出<br/>
 * 活动能够获得许可,并在使用之后释放许可,如果没有剩余许可,acquire将会被阻塞<br/>
 * release向信号量返回一个许可,
 * Created by LZJ on 2015/12/8.
 */
public class CountingSemaphore<T> {

    private final Set<T> set;
    private final Semaphore sem;

    public CountingSemaphore(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<T>());
        sem = new Semaphore(bound);
    }

    //使用信号量来约束容器
    public boolean add(T o) throws InterruptedException {
        sem.acquire();
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o);
            return wasAdded;
        } finally {
            if (!wasAdded)
                sem.release();
        }
    }

    public boolean remove(Object o) {
        boolean wasRemoved = set.remove(o);
        if (wasRemoved)
            sem.release();
        return wasRemoved;
    }


}
