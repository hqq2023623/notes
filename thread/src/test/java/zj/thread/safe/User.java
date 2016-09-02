package zj.thread.safe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 竞争条件:执行的全部过程必须是原子的<br/>
 * 1.读-改-写  <br/>
 * 2.检查再运行 <br/>
 *
 * @author Lzj Created on 2015/12/18.
 */
public class User {

    private int money = 0;

    private int compare = 0;

    //使用原子类型
    private AtomicInteger ai = new AtomicInteger(0);

    public int getMoney() {
        return money;
    }

    public synchronized int getNext() {
        return money++;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    //使用同步语句块
    public void addAndPrint() {
        System.err.println("----------------->" + compare++);
        synchronized (this) {
            money++;
            System.err.println(getMoney());
        }

    }

    //使用方法级同步
    public void printNext() {
        System.out.println("----------------->" + compare++);
        System.out.println(getNext());
    }

    //使用原子类型
    public void printAtomic() {
        System.out.println("----------------->" + compare++);
        System.out.println(ai.incrementAndGet());
    }


    private final Object obj = new Object();

    private int privateCount = 0;

    //使用私有锁而不是对象的内部锁,使得客户代码无法获得私有锁
    //和使用内部锁synchronized (this)相比,如果不能正确获取内部锁,则会引起活跃度问题
    public void printPrivateLock() {
        synchronized (obj) {
            //访问或修改状态变量
            System.out.println("----------------->" + compare++);
            System.out.println(privateCount++);
        }
    }


}

