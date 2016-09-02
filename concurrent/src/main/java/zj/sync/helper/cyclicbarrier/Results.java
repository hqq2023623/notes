package zj.sync.helper.cyclicbarrier;

/**
 * 结果类--保存矩阵中每行找到指定数字的次数
 *
 * @author Lzj Created on 2016/3/19.
 */
public class Results {

    private int[] data;

    public Results(int size) {
        data = new int[size];
    }

    public int[] getData() {
        return data;
    }

    //设置指定索引和对应的值
    public void setData(int position, int value) {
        data[position] = value;
    }

}
