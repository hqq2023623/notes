package zj.juc.block.prior.queue;

/**
 * @author Lzj Created on 2016/4/1.
 */
public class Event implements Comparable<Event> {

    //存放创建了event的线程数
    private int thread;
    //存放event的优先级
    private int priority;

    public Event(int thread, int priority) {
        this.thread = thread;
        this.priority = priority;
    }

    //比较当前event与参数event的优先级
    //当前的大返回-1
    @Override
    public int compareTo(Event event) {
        if (priority > event.getPriority()) {
            return -1;
        } else if (priority < event.getPriority()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getThread() {
        return thread;
    }

    public void setThread(int thread) {
        this.thread = thread;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
