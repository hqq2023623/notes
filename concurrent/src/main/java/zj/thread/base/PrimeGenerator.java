package zj.thread.base;

/**
 * 线程的中断，通过继承Thread的方式实现线程
 *
 * @author Lzj Created on 2015/12/18.
 */
public class PrimeGenerator extends Thread {

    public static void main(String[] args) {
        Thread t = new PrimeGenerator();
        t.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //中断线程
        t.interrupt();
        //也可以调用静态方法
//        Thread.interrupted();
    }


    @Override
    public void run() {
        long number = 1L;

        while (true) {
            if (isPrime(number)) {
                System.out.println("Number " + number + " is Prime");
            }
            //判断线程的interrupted属性是否为true
            if (isInterrupted()) {
                System.out.println("The Prime Generator has been Interrupted");
                return;
            }
            number++;
        }
    }

    private boolean isPrime(long number) {
        if (number <= 2) {
            return true;
        }
        for (long i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


}


