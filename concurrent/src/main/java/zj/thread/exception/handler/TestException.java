package zj.thread.exception.handler;

/**
 * Created by lzj on 2016/3/26.
 */
public class TestException implements Runnable {
    //抛出数组下标越界异常
    @Override
    public void run() {
        int[] a = new int[1];
        System.out.println(a[2]);
    }
    public static void main(String[] args) {
        Thread t = new Thread(new TestException());
        //设置运行时异常处理器
        t.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler());
        t.start();
    }
}
