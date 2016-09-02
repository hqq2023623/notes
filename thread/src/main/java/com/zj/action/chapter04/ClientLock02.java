package com.zj.action.chapter04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 客户端加锁<br/>
 * 扩展功能而不是扩展类本身,把扩展代码放入一个助手类中(这里是ClientLock02)
 * Created by LZJ on 2015/12/8.
 */
public class ClientLock02<E> {

    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    //缺少即加入的操作,这是错误的
    //错在这里的同步行为发生在错误的锁上,无论list使用哪个锁保护它的状态,那个锁都没有用到助手类上
    //即使一个list的操作全部声明为同步的,但是使用了不同锁,就意味着操作不是原子性的
    public synchronized boolean addIfAbsent(E x) {
        boolean absent = !list.contains(x);
        if (absent) {
            list.add(x);
        }
        return absent;
    }

    //正确的用法
    //客户端加锁必须保证客户端代码与对象x保护自己状态使用的锁是相同的
    //为了正确执行客户端加锁,你必须知道x使用了哪个锁
    //客户端加锁会破坏同步策略的封装性
    public boolean putIfAbsent(E x) {
        synchronized (list) {
            boolean absent = !list.contains(x);
            if (absent) {
                list.add(x);
            }
            return absent;
        }
    }

}
