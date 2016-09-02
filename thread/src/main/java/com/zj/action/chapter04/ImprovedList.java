package com.zj.action.chapter04;

import java.util.List;

/**
 * 在维护线程安全性的过程中,文档是最强大的<br/>
 * 为类的用户编写线程安全担保的文档,为类的维护者编写类的同步策略文档<br/>
 * 策略: synchronized、volatile、线程安全类<br/>
 * 哪些锁保护哪些变量，将哪些变量声明为volatile，哪些变量被锁保护，哪些变量是不可变的，哪些操作必须是原子的<br/>
 * 编写文档告诉用户获得哪个锁才能保证安全地添加新操作<br/>
 * 可以写一个annotation@GaredBy
 * Created by LZJ on 2015/12/8.
 */
public class ImprovedList<E> {

    //final
    private final List<E> list;

    public ImprovedList(List<E> list) {
        this.list = list;
    }

    //通过使用内部锁,增加了一个新的锁层,优点是不用关心list是否线程安全,缺点是会损失部分性能
    public synchronized boolean addIfAbsent(E x) {
        boolean absent = !list.contains(x);
        if (absent) {
            list.add(x);
        }
        return absent;
    }

}
