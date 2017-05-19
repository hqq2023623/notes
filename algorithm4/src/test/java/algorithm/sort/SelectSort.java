package algorithm.sort;

import zj.sort.SortTemplate;

/**
 * Created by lzj on 2017/5/19.
 */
public class SelectSort extends SortTemplate {

    @Override
    protected void sort(Comparable[] a) {
        int n = a.length;
        //n-1趟排序，每次选择最小的和a[i]交换 ，然后再从剩余元素中选择
        int minIndex;
        for (int i = 0; i < n; i++) {
            minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (lessThan(a[j], a[minIndex])) {
                    minIndex = j;
                }
            }
            exchange(a, i, minIndex);
            show(a);
        }
    }


}
