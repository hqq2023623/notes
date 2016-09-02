package com.zj.action.chapter06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * TaskExecutionWebServer
 * <p>
 * Web server using a thread pool
 *
 * @author Brian Goetz and Tim Peierls
 */
public class TaskExecutionWebServer02 {

    //Executor可以用于异步任务执行,并支持很多种不同类型的任务执行策略
    //为任务提交和任务执行提供了标准的解耦方法,为使用Runnable描述任务提供了通用的方式
    //提交任务的执行者是生产者(产生待完成的工作单元),执行任务的是消费者
    //这种解耦的价值在于让你可以简单地为一个类给定的任务制定策略
    //一个执行策略指明了任务执行的"what,where,which,how"
    //what : 任务在什么线程执行
    //任务以什么顺序实行(FIFO,LIFO,优先级)?
    //在一个任务的执行前后应该做什么处理
    //how many: 可以有多少个任务并发执行
    //可以有多少个任务进入等待执行队列
    //which : 系统过载时需要放弃一个任务,应该放弃哪一个,how : 如何通知应用程序知道这一切
    //执行策略是资源管理工具

    //无论什么时候看到这种代码new Thread(task).start(); 都可以考虑用Executor来代替Thread

    private static final int NTHREADS = 100;
    private static final Executor exec
            = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = () -> handleRequest(connection);
            exec.execute(task);
        }
    }

    private static void handleRequest(Socket connection) {
        // request-handling logic here
    }
}
