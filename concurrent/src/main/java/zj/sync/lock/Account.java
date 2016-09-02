package zj.sync.lock;

/**
 * 银行账户
 *
 * @author Lzj Created on 2015/12/18.
 */
public class Account {

    //余额
    private Double balance;

    private final Object obj = new Object();

    //把传入的数量加入到余额balance中
//    public synchronized void addAmount(double amount) {
//        //先获取余额，再增加余额，最后保存余额
//        //导致了线程不安全，需要添加同步
//        double tmp = balance;
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        tmp += amount;
//        balance = tmp;
//    }

    //私有锁，addAmount和subtractAmount必须用的是同一种锁
    public void addAmount(double amount) {
        synchronized (obj) {
            double tmp = balance;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tmp += amount;
            balance = tmp;
        }
    }


    //把传入的数量加入到余额balance中
//    public synchronized void subtractAmount(double amount) {
//        double tmp = balance;
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        tmp -= amount;
//        balance = tmp;
//    }

    //私有锁
    public void subtractAmount(double amount) {
        synchronized (obj) {
            double tmp = balance;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tmp -= amount;
            balance = tmp;
        }
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
