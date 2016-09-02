package zj.sync.lock;

/**
 * @author Lzj Created on 2016/3/17.
 */
public class Bank implements Runnable {

    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        //从账户里面扣钱
        for (int i = 0; i < 100; i++) {
            synchronized (account) {
                account.subtractAmount(100);
            }
        }
    }


}
