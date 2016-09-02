package com.zj;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lzj Created on 2015/12/18.
 */
public class TestGeneric {

    @Test
    public void test01() {
        //这里的?为Fruit的子类
        List<? extends Fruit> ext = new ArrayList<>();
//        ext.add(new Apple());
        //这里的?为Fruit的父类直到Object
        List<? super Fruit> supers = new ArrayList<>();
        supers.add(new Apple());

    }

}

class Fruit {

}

class Apple extends Fruit {

}
