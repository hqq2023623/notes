package algorithm.sort;

import zj.sort.SortTemplate;

/**
 * Created by lzj on 2017/5/19.
 */
public class InsertSort extends SortTemplate {

    @Override
    protected void sort(Comparable[] a) {
        int n = a.length;
        //n-1趟排序，把数组分为两部分，一部分为已排序数组，另一部分为未排序数组
        //每次从未排序数组中选出一个插入已排序数组
        for (int i = 1; i < n; i++) {
            //“插入” ： 从后往前两两比较交换
            for (int j = i; j > 0; j--) {
                if (lessThan(a[j], a[j - 1])) {
                    exchange(a, j, j - 1);
                }
            }
            show(a);
        }
    }


}
