package zj.juc.nonblock.deque;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author Lzj Created on 2016/3/29.
 */
public class AddTask implements Runnable {

    private ConcurrentLinkedDeque<String> list;

    public AddTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    //将10000个字符串粗放到列表中
    //这些字符串由当前执行任务的线程名称和数字组成
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10000; i++) {
            list.add(name + ": Element " + i);
        }
    }
}
