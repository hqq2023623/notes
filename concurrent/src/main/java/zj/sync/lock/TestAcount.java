package zj.sync.lock;

/**
 * @author Lzj Created on 2016/3/17.
 */
public class TestAcount {

    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);

        Thread bank = new Thread(new Bank(account));
        Thread company = new Thread(new Company(account));

        bank.start();
        company.start();

        try {
            bank.join();
            company.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance :  " + account.getBalance());


    }


}
