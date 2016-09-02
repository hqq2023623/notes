package com.zj.jdk8;

/**
 * 函数式接口<br/>
 * 将lambda表达式映射到一个单方法的接口上，这种做法在Java 8之前就有别的语言实现，比如Rhino JavaScript解释器，如果一个函数参数接收一个单方法的接口而你传递的是一个function，Rhino 解释器会自动做一个单接口的实例到function的适配器，典型的应用场景有 org.w3c.dom.events.EventTarget 的addEventListener 第二个参数 EventListener。
 * Created by LZJ on 2015/12/7.
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
