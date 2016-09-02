package com.zj.action.chapter03;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by LZJ on 2015/12/7.
 */
public class Novisibility {

    //volatile是共享的,对它的操作不会和其他内存操作一起被重排序,不会缓存在寄存器或者其他地方,每次返回都是最新的值
    //依赖volatile来控制状态可见性的代码不易维护
    //volatile不能使自增操作原子化
    //使用场景: 用于标识重要的生命周期(开始或者关闭)
    private volatile int a;

    private static boolean ready;

    private static int number;

    private static class ReadThread extends Thread {
        public void run() {
            if (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }

        volatile boolean shutdown;

        public void dot() {
            while (!shutdown) {
            }
        }
    }

    //线程可能会一直保持循环,因为对于读线程来说,ready的值可能永远不可见
    //可能会打印0,因为在对number赋值之前,主线程就已经写入ready的值并使之对读取线程可见,称为重排序
    //会导致看到过期数据
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new ReadThread().start();
            number = 32 + i;
            ready = true;
        }

    }

    //锁和可见性
    //拥有相同的锁的线程见到的共享变量的值是相同的,对变量的操作对它们是透明的

    //栈限制:把变量限制在方法中

}

class People {

    private Person person;

    //这是不安全发布,其他线程看到的可能是null或者旧值
    public People() {
        person = new Person();
    }
}

class Person {

    //安全发布一个对象:
    //通过静态初始化器初始化对象的引用
    private static People people = new People();
    //将它的引用保存到Atomic域或者AtomicReference中
    private AtomicReference<Person> person = new AtomicReference<>();
    //将它的引用存储到正确创建的对象的final域中
    //将它的引用存储到由锁正确保护的的域中

    //使用和共享对象的一些最有效策略:
    //1.线程限制
    //2.共享只读对象
    //3.共享线程安全
    //4.被守护的(锁和线程安全对象持有的对象)

}
