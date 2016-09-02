package zj.thread.exception.handler;

/**
 * Created by lzj on 2016/3/26.
 */
public class ThreadExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t.getName() + "  throws an exception");
        e.printStackTrace();
    }
}
