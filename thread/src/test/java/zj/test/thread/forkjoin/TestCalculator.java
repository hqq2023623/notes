package zj.test.thread.forkjoin;

import org.junit.Test;
import zj.thread.forkjoin.Calculator;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

/**
 * @author Lzj Created on 2015/12/18.
 */
public class TestCalculator {

    @Test
    public void test01() {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //从0累加到10000
        Future<Integer> result = forkJoinPool.submit(new Calculator(0, 10000));
        try {
            assertEquals(new Integer(49995000), result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
