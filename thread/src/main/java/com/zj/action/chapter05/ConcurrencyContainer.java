package com.zj.action.chapter05;

/**
 * 并发容器<br/>
 * <p>
 * Created by LZJ on 2015/12/8.
 */
public class ConcurrencyContainer {

    public static void main(String[] args) {

        //ConcurrentHashMap
        //ConcurrentHashMap使用更细化的锁--分离锁
        //可以有无限制的读线程并发访问map,但是只有有限的写线程可以并发修改map
        //不需要在容器迭代中加锁
        //只有在程序需要独占访问中加锁时,ConcurrentHashMap才无法胜任.否则大多数情况都可以用ConcurrentHashMap

        //CopyOnWriteArrayList
        //写入时复制(copy-on-wirte)基于这样一个事实:如果一个不可变对象被正确地发布,那么访问它就不需要更多的同步


    }


}
