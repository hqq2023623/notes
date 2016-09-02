package zj;

/**
 * synchronized加锁的方式
 *
 * @author Lzj Created on 2016/3/24.
 */
public class TestSync {

    private final Object o = new Object();

    private boolean flag = false;

    public synchronized void a() {
    }

    public void b() {
        //等同于在方法上加sync
        synchronized (this) {
        }
    }

    //静态同步方法
    public synchronized void e() {
    }

    //针对类的锁，该类的所有对象都是用这个锁
    public void f() {
        synchronized (this.getClass()) {
        }
    }

    public void c() {
        synchronized (o) {
        }
    }

    //wait()与循环
    public void d() {
        this.getClass().getClassLoader().getResource("a.txt");
        this.getClass().getClassLoader().getResourceAsStream("b.txt");

        //不能用if
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
