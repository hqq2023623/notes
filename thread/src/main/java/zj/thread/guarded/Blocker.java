package zj.thread.guarded;

import java.util.concurrent.Callable;

/**
 * Created by lzj on 2017/5/2.
 */
public interface Blocker {

    /**
     * 在保护条件成立时执行目标动作，否则阻塞当前线程
     *
     * @param guardedAction
     * @param <V>
     * @return
     */
    <V> V callWithGuard(GuardedAction<V> guardedAction) throws Exception;

    /**
     * 执行stateOperation所指定的操作后，决定是否唤醒本Blocker所暂挂的所有线程中的一个线程 , signal
     *
     * @param stateOperation
     */
    void signalAfter(Callable<Boolean> stateOperation) throws Exception;

    void signal() throws InterruptedException;

    /**
     * 执行stateOperation所指定的操作后，决定是否唤醒本Blocker所暂挂的所有线程中的所有线程 , signalAll
     *
     * @param stateOperation
     * @throws Exception
     */
    void bradcastAfter(Callable<Boolean> stateOperation) throws Exception;


}
