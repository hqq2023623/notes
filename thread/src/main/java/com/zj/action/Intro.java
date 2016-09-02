package com.zj.action;

import java.util.Comparator;
import java.util.List;

/**
 * JAVA并发编程实践--介绍<br/>
 * 编写线程安全的代码,本质上就是管理对状态的访问,通常都是可变的、共享的状态<br/>
 * 一个对象的状态就是它的数据,存储在状态变量中<br/>
 * 共享:一个变量可以被多个线程访问<br/>
 * 可变:变量的值在其生命周期内可以被改变<br/>
 * 无论何时,只要有对于一个线程访问同一个变量,而且某个线程会写入该变量,都需要同步<br/>
 * Created by LZJ on 2015/12/7.
 */
public class Intro {

    private int value;

    public <T extends Comparator<? super T>> void sort(List<T> list) {
        //永远不要返回错误答案
        System.exit(0);
    }

    //非线程安全的,这里可以拆分为三个操作:读取值,+1,保存值
    public int getNext() {
        return value++;
    }

    //由"this"保证线程安全(即每个调用了该方法[获得了锁]的对象保证)
    public synchronized int safeGetNext() {
        return value++;
    }

    //在没有正确同步的情况下修复程序的方法:
    //1.不要跨线程共享变量
    //2.把变量声明为final
    //3.在任何访问状态变量的时候使用同步





}
