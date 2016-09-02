package zj.thread.base;

/**
 * @author Lzj Created on 2015/12/18.
 */
public class TestInterruptException implements Runnable {

    public static void main(String[] args) {
        Thread t = new Thread(new TestInterruptException());
        t.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //中断该线程实例
        t.interrupt();
    }

    @Override
    public void run() {
        //while(true)也要在try-catch块里面
        int number = 0;
        try {
            while (true) {
                checkNum(number);
                number++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(Thread.currentThread().getName() + " is interrupted");
        }
    }

    private void checkNum(int number) throws InterruptedException {
        if (number % 50000000 == 3) {
            System.out.print(number);
        }
        //检测当前线程是否已经中断了
        if (Thread.interrupted()) {
            //发出通知线程已经处于中断状态
            throw new InterruptedException();
        }
    }
}
