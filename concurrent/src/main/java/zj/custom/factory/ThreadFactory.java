package zj.custom.factory;

/**
 * 线程工厂
 *
 * @author Lzj Created on 2015/12/18.
 */
public interface ThreadFactory {

    Thread newThread(Runnable r);


}
