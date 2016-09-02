package zj.custom.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Lzj Created on 2015/12/18.
 */
public class MyThreadFactory implements ThreadFactory {

    private int counter;

    private String name;

    private List<String> stats;

    public MyThreadFactory(String name) {
        this.counter = 0;
        this.name = name;
        this.stats = new ArrayList<>();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, name + "-Thread-" + counter);
        counter++;
        stats.add(String.format("create thread ") + t.getId() + " with name " + t.getName() + " on " + new Date());
        return t;
    }

    //获取当前所有线程对象的统计信息
    public String getStats() {
        StringBuffer buffer = new StringBuffer();
        Iterator<String> it = stats.iterator();
        while (it.hasNext()) {
            buffer.append(it.next());
            buffer.append("\n");
        }
        return buffer.toString();
    }


}
