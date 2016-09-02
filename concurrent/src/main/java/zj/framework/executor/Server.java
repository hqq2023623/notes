package zj.framework.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Lzj Created on 2016/3/17.
 */
public class Server {

    private ThreadPoolExecutor executor;

    public Server() {
        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }

    public void executeTask(ExecTask task) {
        System.out.println("Server: A new task has arrived");
        executor.execute(task);
        System.out.println("Server: Pool Size:" + executor.getPoolSize());
        System.out.println("Server: Active count:" + executor.getActiveCount());
        System.out.println("Server: Completed Tasks:" + executor.getCompletedTaskCount());
    }

    public void endServer() {
        executor.shutdown();
    }




}
