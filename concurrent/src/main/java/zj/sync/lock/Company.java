package zj.sync.lock;

/**
 * @author Lzj Created on 2016/3/17.
 */
public class Company implements Runnable {

    private Account account;

    public Company(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        //向账户存钱
        for (int i = 0; i < 100; i++) {
            synchronized (account) {
                account.addAmount(100);
            }
        }
    }


}
