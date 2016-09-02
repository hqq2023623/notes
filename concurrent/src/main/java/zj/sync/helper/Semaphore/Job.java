package zj.sync.helper.Semaphore;


/**
 * @author Lzj Created on 2016/3/17.
 */
public class Job implements Runnable {

    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": is going to print a document");
        printQueue.printJob(new Object());
        System.out.println(Thread.currentThread().getName() + ": has been printed");
    }


}



