package com.zj.base;

import org.junit.Test;

/**
 * Created by LZJ on 2015/12/3.
 */
public class TestBase {

//    public static void main(String[] args) {
//        new InheritThread().start();
//        new Thread(new RunnableThread()).start();
//    }

    //不知道为啥junit测试不打印数据
    @Test
    public void testInherit() {
        new InheritThread().start();
    }

    @Test
    public void testRunnable() {
        new Thread(new RunnableThread()).start();
    }


}
