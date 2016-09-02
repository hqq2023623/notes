package zj.lock.condition;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Lzj Created on 2016/3/17.
 */
public class FileBuffer {

    //存放共享的数据
    private LinkedList<String> buffer;
    //存放buffer的长度
    private int maxSize;
    //对修改buffer的代码块进行控制
    private ReentrantLock lock;

    private Condition lines;

    private Condition space;
    //是否还需要添加更多的数据到缓冲区
    private boolean pendingLines;

    public FileBuffer(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LinkedList<>();
        lock = new ReentrantLock();
        lines = lock.newCondition();
        space = lock.newCondition();
        pendingLines = true;
    }


    //把字符串写入到缓冲区中
    public void insert(String line) {
        lock.lock();
        try {
            //检查缓冲区是否已满
            while (buffer.size() == maxSize) {
                //等待
                space.await();
            }
            //向链表末尾添加字符串
            buffer.offer(line);
            System.out.println(Thread.currentThread().getName() + "  Inserted Line : " + buffer.size());
            //通知所有等待缓冲区中有数据的线程
            lines.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.unlock();
        }
    }

    public String get() {
        String line = null;
        lock.lock();

        try {
            while (buffer.size() == 0 && hasPendingLines()) {
                lines.await();
            }
            if (hasPendingLines()) {
                line = buffer.poll();
                System.out.println(Thread.currentThread().getName() + "  Line Readed : " + buffer.size());
                space.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.unlock();
        }
        return line;
    }

    //设置pendingLines，当生产者不再产生新的数据时，设置为false
    public void setPendingLines(boolean pendingLines) {
        this.pendingLines = pendingLines;
    }

    //缓冲区是否还有数据可以处理
    public boolean hasPendingLines() {
        return pendingLines || buffer.size() > 0;
    }


}
