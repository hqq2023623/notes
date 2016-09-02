package zj.sync.helper.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 在随机数矩阵指定的行中查找某个数（分治：把矩阵分成了n行）
 *
 * @author Lzj Created on 2016/3/19.
 */
public class MatrixSearcher implements Runnable {

    private int firstRow;

    private int lastRow;

    private MatrixMock matrixMock;

    private Results results;

    //要查找的数字
    private int number;

    private final CyclicBarrier cyclicBarrier;

    public MatrixSearcher(CyclicBarrier cyclicBarrier, int firstRow, int lastRow, MatrixMock matrixMock, Results results, int number) {
        this.cyclicBarrier = cyclicBarrier;
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.matrixMock = matrixMock;
        this.results = results;
        this.number = number;
    }

    @Override
    public void run() {
        //存放每行查找到的次数
        int counter;
        System.out.println(Thread.currentThread().getName() + " Processing lines from " + firstRow + "  to " + lastRow);
        //在要查找的所有行中进行查找是否包含指定数字并把结果保存到对应的results对象的相应位置
        for (int i = firstRow; i < lastRow; i++) {
            int row[] = matrixMock.getRow(i);
            counter = 0;
            for (int j = 0; j < row.length; j++) {
                if (row[j] == number) {
                    counter++;
                }
            }
            results.setData(i, counter);
        }
        System.out.println(Thread.currentThread().getName() + "  lines processed ");
        //当前扫描完成就进入阻塞状态，等待所有线程完成扫描
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }


}
