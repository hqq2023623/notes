package zj.custom.prior.executor;

import java.util.concurrent.TimeUnit;

/**
 * @author Lzj Created on 2016/4/1.
 */
public class MyPriorityTask implements Runnable, Comparable<MyPriorityTask> {

    private int priority;

    private String name;

    public MyPriorityTask(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    @Override
    public int compareTo(MyPriorityTask o) {
        if (this.priority < o.getPriority()) {
            return 1;
        } else if (this.getPriority() > o.getPriority()) {
            return -1;
        }
        return 0;
    }

    @Override
    public void run() {
        System.out.println("MyPriorityTask : " + name + "  Priority : " + priority);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
