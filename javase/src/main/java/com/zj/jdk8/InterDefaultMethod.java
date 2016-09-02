package com.zj.jdk8;

/**
 * 接口的默认方法
 * Created by LZJ on 2015/12/7.
 */
public interface InterDefaultMethod {

    //所有方法共享
    default void print() {
        System.out.println("This is a default method");
    }

}
