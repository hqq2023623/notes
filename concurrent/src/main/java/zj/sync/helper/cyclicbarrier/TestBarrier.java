package zj.sync.helper.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @author Lzj Created on 2016/3/19.
 */
public class TestBarrier {

    public static void main(String[] args) {

        final int ROWS = 10000;
        final int NUMBERS = 1000;
        final int TARGET = 5;
        final int PARTICIPANTS = 5;
        final int LINES_PARTICIPATN = 2000;

        //1000行每行1000个数字，要查找的数字是5
        MatrixMock mock = new MatrixMock(ROWS, NUMBERS, TARGET);
        //10000个元素的results
        Results results = new Results(ROWS);

        Grouper grouper = new Grouper(results);

        //等待5个线程运行结束后，将执行创建的Grouper线程对象
        CyclicBarrier cyclicBarrier = new CyclicBarrier(PARTICIPANTS, grouper);

        //创建5个查找类
        MatrixSearcher[] searchers = new MatrixSearcher[PARTICIPANTS];
        for (int i = 0; i < PARTICIPANTS; i++) {
            searchers[i] = new MatrixSearcher(cyclicBarrier, i * LINES_PARTICIPATN, i * LINES_PARTICIPATN + LINES_PARTICIPATN, mock, results, 5);
            Thread t = new Thread(searchers[i]);
            t.start();
        }
        System.out.println("Main : The main thread has finished.");
    }


}
