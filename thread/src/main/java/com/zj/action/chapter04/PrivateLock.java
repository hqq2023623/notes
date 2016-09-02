package com.zj.action.chapter04;

/**
 * Created by LZJ on 2015/12/7.
 */
public class PrivateLock {

    private final Object obj = new Object();

    void doSth() {
        //使用私有锁而不是对象的内部锁,使得客户代码无法获得私有锁
        synchronized (obj) {
            //访问或修改状态变量
        }
    }


}
