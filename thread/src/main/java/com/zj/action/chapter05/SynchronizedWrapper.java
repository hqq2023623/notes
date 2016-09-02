package com.zj.action.chapter05;

import java.util.Vector;

/**
 * 同步容器都是线程安全的,但是对于符合操作,可能需要添加额外的客户端锁进行保护<br/>
 * 复合操作:迭代，导航(根据一定的顺序寻找下一个元素),缺少即加入,检查map的关键字,缺少则添加<br/>
 * 当其他线程并发修改容器的时候就可能不会按照期望的方式工作<br/>
 * <p>
 * Created by LZJ on 2015/12/8.
 */
public class SynchronizedWrapper {

    //复合操作,线程不安全
    public static int getLast(Vector<Integer> vector) {
        int last = vector.size() - 1;
        return vector.get(last);
    }

    //复合操作需要添加客户端锁
    public static int safeGetLast(Vector<Integer> vector) {
        //迭代的时候也要同步
        synchronized (vector) {
            for (int i = 0; i < vector.size(); i++) {
                vector.get(i);
            }
        }

        synchronized (vector) {
            int last = vector.size() - 1;
            return vector.get(last);
        }
    }


}
