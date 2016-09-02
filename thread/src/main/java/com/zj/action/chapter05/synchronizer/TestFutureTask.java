package com.zj.action.chapter05.synchronizer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTask的实现描述了一个抽象的可携带计算结果的计算<br/>
 * FutureTask的计算是通过Callable来实现的,它相当于一个可携带计算结果的Runnable<br/>
 * 它有三个状态:等待、运行、完成.一旦进入完成状态就不会再改变.<br/>
 * 正常结束、取消和异常都会使其进入完成状态<br/>
 * Future.get依赖于任务的状态,只有任务已经完成了才会返回结果,不然会一直阻塞<br/>
 * FutureTask把计算的结果从运行计算的线程传送到需要结果的线程<br/>
 * <p>
 * Created by LZJ on 2015/12/8.
 */
public class TestFutureTask {

    ProductInfo loadProductInfo() throws DataLoadException {
        return null;
    }

    //相当于runnable
    private final FutureTask<ProductInfo> future =
            new FutureTask<ProductInfo>(() -> loadProductInfo());

    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    //启动后需要计算结果的时候可以调用这个方法
    //get抛出异常的三种情况:编译器(受检查的异常)、非检测异常:运行时异常、Error
    public ProductInfo get()
            throws DataLoadException, InterruptedException {
        try {
            return future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof DataLoadException)
                throw (DataLoadException) cause;
            else
                throw LaunderThrowable.launderThrowable(cause);
        }
    }

    interface ProductInfo {
    }
}

class DataLoadException extends Exception {
}
