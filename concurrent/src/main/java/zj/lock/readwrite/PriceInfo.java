package zj.lock.readwrite;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Lzj Created on 2016/3/17.
 */
public class PriceInfo {

    private double price1;

    private double price2;

    //读写锁
    private ReadWriteLock lock;

    public PriceInfo() {
        price1 = 1.0;
        price2 = 2.0;
        lock = new ReentrantReadWriteLock();
    }

    //获取price1
    public double getPrice1() {
        //读锁
        lock.readLock().lock();
        double value = price1;
        //记得释放锁
        lock.readLock().unlock();
        return value;
    }

    //获取price2
    public double getPrice2() {
        //读锁
        lock.readLock().lock();
        double value = price2;
        //记得释放锁
        lock.readLock().unlock();
        return value;
    }

    public void setPrices(double price1, double price2) {
        //写锁
        lock.writeLock().lock();
        this.price1 = price1;
        this.price2 = price2;
        //记得释放锁
        lock.writeLock().unlock();
    }


}
