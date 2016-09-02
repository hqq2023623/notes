package com.zj.action.chapter02;

import java.math.BigInteger;

/**
 * Created by LZJ on 2015/12/7.
 */
public class Concurrency04 {

    private int count;

    private BigInteger lastNumber;

    private BigInteger[] lastFactors;

    public synchronized int getCount() {
        return count;
    }

    //假设这是servlet的service方法
    //弱并发(poor concurrency):会把发送过来的请求依次排队执行
    public synchronized void service() {
    }

    //提升性能的方法,把耗时而且不影响共享变量的操作分离出同步块
    public void service02() {
        //count是共享变量,不需要使用Atomic类,两种锁放在一起不是好事
        BigInteger[] factors = null;
        BigInteger i = BigInteger.ONE;
        synchronized (this) {
            count++;
            if (i.equals(count)) {
                factors = lastFactors.clone();
            }
        }
        //i并不是共享变量
        if (factors == null) {
            factors = new BigInteger[1];
            synchronized (this) {
                lastNumber = i;
                lastFactors = factors.clone();
            }
        }

    }

}
