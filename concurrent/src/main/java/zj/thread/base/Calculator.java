package zj.thread.base;

/**
 * @author Lzj Created on 2015/12/18.
 */
public class Calculator implements Runnable {

    private static final int COUNT = 10;

    private int number;

    public Calculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < COUNT; i++) {
//            System.out.println(Thread.currentThread().getName() + " number : " + number
//                    + "  i : " + i + "  number * i : " + number * i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < COUNT; i++) {
            Thread t = new Thread(new Calculator(i));
            System.out.println(t.getState());
            t.start();
            System.out.println(t.getState());
        }
    }

}
