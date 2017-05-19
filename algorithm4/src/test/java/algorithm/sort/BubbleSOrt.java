package algorithm.sort;

import zj.sort.SortTemplate;

/**
 * Created by lzj on 2017/5/19.
 */
public class BubbleSort extends SortTemplate {

    @Override
    protected void sort(Comparable[] a) {
        int n = a.length;
        //n-1趟排序，每次把最小的“上浮” ，然后继续对剩余元素上浮
        for (int i = 1; i < n; i++) {
            //从后往前遍历，每次发现倒序就交换
            for (int j = n - 1; j >= i; j--) {
                if (lessThan(a[j], a[j - 1])) {
                    exchange(a, j, j - 1);
                }
            }
            show(a);
        }
    }


}
