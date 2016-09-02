package zj.thread.group;

/**
 * Created by lzj on 2016/3/29.
 */
public class TestGroup {

    public static void main(String[] args) {
        BooleanHolder holder = new BooleanHolder();
        ThreadGroup[] group = new ThreadGroup[5];
        Thread thread;
        for (int i = 0; i < 5; i++) {
            thread = new Thread(group[i], new ReadThread(holder));
            thread.start();
            thread = new Thread(group[i], new WriteThread(holder));
            thread.start();
        }
    }


}
