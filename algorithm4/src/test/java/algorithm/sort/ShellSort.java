package algorithm.sort;

import zj.sort.SortTemplate;

/**
 * 分组插入排序，增量递减
 * Created by lzj on 2017/5/19.
 */
public class ShellSort extends SortTemplate {

    @Override
    protected void sort(Comparable[] a) {
        int i, j, d;
        //增量递减
        for (d = a.length / 2; d >= 1; d /= 2) {
            //分组进行插入排序
            for (i = d; i < a.length; i++) {
                //插入排序， 子序列为 a[i]、a[i-d]、a[i - 2*d] ……
                for (j = i; j >= d; j -= d) {
                    if (lessThan(a[j], a[j - d])) {
                        exchange(a, j, j - d);
                    }
                }
            }
            show(a);
        }

    }


}
