package com.zj.tij.init;

/**
 * @author Lzj Created on 2015/12/18.
 */
public class Testinit {

//    这是错的,因为按照初始化顺序,i此时还没有值
//    private int j = g(i);

    private int i = f();

    private int j = g(i);

    private int f() {
        return 11;
    }

    private int g(int n) {
        return n * 10;
    }


}
