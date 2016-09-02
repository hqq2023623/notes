package zj.custom.executor;

import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * 定制ThreadPoolExecutor类
 *
 * @author Lzj Created on 2016/3/21.
 */
public class MyExecutor extends ThreadPoolExecutor {

    private ConcurrentHashMap<String, Date> startTimes;

    public MyExecutor(int corePoolSIze, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSIze, maximumPoolSize, keepAliveTime, unit, workQueue);
        startTimes = new ConcurrentHashMap<>();
    }

    //任务执行前
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        System.out.println("MyExecutor : A task is begging : " + t.getName() + "  " + r.hashCode());
        startTimes.put(String.valueOf(r.hashCode()), new Date());
    }

    //执行任务后


    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        Future<?> result = (Future<?>) r;

        System.out.println("***********************");
        System.out.println("MyExecutor : A task is finishing.");
        try {
            System.out.println("MyExecutor : Result : " + result.get());
            Date startDate = startTimes.remove(String.valueOf(r.hashCode()));
            Date finishDate = new Date();
            long diff = finishDate.getTime() - startDate.getTime();
            System.out.println("MyExecutor : Duration : " + diff);
            System.out.println("********************");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        super.afterExecute(r, t);
    }

    //把已执行完成的任务、正在执行的任务和等待执行的任务的信息输出到控制台
    @Override
    public void shutdown() {
        System.out.println("MyExecutor : Going to shutdown");
        System.out.println("MyExecutor : Executed tasks : " + getCompletedTaskCount());
        System.out.println("MyExecutor : Running tasks: " + getActiveCount());
        System.out.println("MyExecutor : Pending tasks : " + getQueue().size());
        super.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        System.out.println("MyExecutor : Going to shutdown immediately");
        System.out.println("MyExecutor : Executed tasks : " + getCompletedTaskCount());
        System.out.println("MyExecutor : Running tasks: " + getActiveCount());
        System.out.println("MyExecutor : Pending tasks : " + getQueue().size());
        return super.shutdownNow();
    }
}
