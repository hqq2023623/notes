package zj.custom.factory;

/**
 * @author Lzj Created on 2015/12/18.
 */
public class TestThreadFactory {

    public static void main(String[] args) {
        MyThreadFactory factory = new MyThreadFactory("lzj");
        Task t = new Task();
        Thread thread;
        System.out.println("start create thread");
        for (int i = 0; i < 10; i++) {
            thread = factory.newThread(t);
            thread.start();
        }
        System.out.println(factory.getStats());
    }





}
