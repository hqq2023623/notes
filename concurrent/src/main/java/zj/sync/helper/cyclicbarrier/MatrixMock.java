package zj.sync.helper.cyclicbarrier;

import java.util.Random;

/**
 * 矩阵模拟类，将在该数字矩阵中寻找一个数字（使用分治编程技术）。
 * 这个矩阵会被分成几个子集，然后每个线程在一个子集中寻找。
 * 一旦所有线程都完成查找，最终的任务将统一这些结果
 *
 * @author Lzj Created on 2016/3/19.
 */
public class MatrixMock {

    //二维矩阵,先行(row)后列(column)
    private int[][] data;

    //用随机数字为矩阵赋值，每生成一个数字，就用它跟要查找的数字比较。如果一致，就将计数器counter+1
    public MatrixMock(int size, int length, int number) {
        int counter = 0;
        data = new int[size][length];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < length; j++) {
                data[i][j] = random.nextInt(10);
                if (data[i][j] == number) {
                    counter++;
                }
            }
        }
        System.out.println("Mock : There are " + counter + " ocurrences of number in generated data");
    }

    //获取矩阵行序号
    public int[] getRow(int row) {
        if (row >= 0 && row < data.length) {
            return data[row];
        }
        return null;
    }


}
