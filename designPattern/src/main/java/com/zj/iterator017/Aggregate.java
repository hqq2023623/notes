package com.zj.iterator017;

/**
 * 相当于集合类
 */
public interface Aggregate {

    void add(Object obj);

    void remove(Object obj);

    Iterator iterator();

}
