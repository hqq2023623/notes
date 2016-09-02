package zj.juc.atomic;

/**
 * @author Lzj Created on 2016/4/1.
 */
public class TestAtomic {


    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);

        Company company = new Company(account);
        Thread companyThread = new Thread(company);

        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);

        companyThread.start();
        bankThread.start();

        try {
            companyThread.join();
            bankThread.join();
            System.out.println("Account: Final Balance  : " + account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
