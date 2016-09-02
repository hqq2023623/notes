package com.zj.model;

import java.util.Vector;

/**
 * 同步的消息队列
 * Created by LZJ on 2015/12/3.
 */
public class MsgQueue {

    Vector<Object> queue = new Vector<>();

    //添加一条消息
    public synchronized void send(Object obj) {
        queue.add(obj);
    }

    //删除第一个元素并返回它
    public synchronized Object recv() {
        if (queue.size() == 0) {
            return null;
        }
        Object obj = queue.firstElement();
        queue.removeElementAt(0);
        return obj;
    }


}
