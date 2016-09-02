package com.zj.action.chapter06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ThreadPerTaskWebServer
 * <p>
 * Web server that starts a new thread for each request
 *
 * @author Brian Goetz and Tim Peierls
 */
public class ThreadPerTaskWebServer {

    //为每个请求创建一个线程
    //三点结论:
    //1.执行任务的负载已经脱离了主线程,这让住循环能够更迅速地重新开始等待下一个连接
    //2.并行处理任务,这使得多个请求可以同时得到服务
    //3.任务处理代码必须是线程安全的
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = () -> handleRequest(connection);
            new Thread(task).start();
        }
    }

    //存在的缺陷
    //1.线程声明周期的开销
    //2.资源消耗量
    //3.稳定性,应该限制线程的数量

    private static void handleRequest(Socket connection) {
        // request-handling logic here
    }
}
