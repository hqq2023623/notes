package zj.juc.atomic;

/**
 * @author Lzj Created on 2016/4/1.
 */
public class Bank implements Runnable {

    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.subtractAmount(1000);
        }
    }


}
