package zj.thread.guarded;

import java.util.concurrent.Callable;

/**
 * Created by lzj on 2017/5/2.
 */
public abstract class GuardedAction<V> implements Callable<V> {
    protected final Predicate guard;

    public GuardedAction(Predicate guard) {
        this.guard = guard;
    }
}
