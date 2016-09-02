package zj.lock.distributed;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 简单的分布式锁
 *
 * @author Lzj Created on 2016/3/31.
 */
public interface DistributedLock extends Remote {

    long lock() throws RemoteException, TimeoutException;

    long tryLock(long time, TimeUnit unit) throws RemoteException, TimeoutException;

    void unlock(long token) throws RemoteException;


}
