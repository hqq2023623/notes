package algorithm.sort;

import zj.sort.SortTemplate;

import java.util.Comparator;

/**
 * 归并排序 : 对有序序列的两两合并 ， 有序序列个数递减， 序列中个数递增直到长度为n，此时 只剩一个有序序列
 * Created by lzj on 2017/5/19.
 */
public class MergeSort extends SortTemplate {

    @Override
    protected void sort(Comparable[] a) {
        mergeSort(a.length - 1, a);
    }

    //自底向上的归并
    private void mergeSort(int n, Comparable[] a) {
        int h = 1;
        Comparable[] b = new Comparable[a.length];
        //用有序序列长度来控制排序结束
        while (h <= n) {
            mergePass(n, h, a, b);
            h *= 2;
            //a、b 互换位置
            mergePass(n, h, b, a);
            h *= 2;
        }
    }


    /**
     * 一趟归并排序
     *
     * @param n 数组最大下标
     * @param h 每个子序列的长度
     * @param a 待合并数组
     * @param b 合并后的数组
     */
    private void mergePass(int n, int h, Comparable[] a, Comparable[] b) {
        int i, t;
        //把长度为h的有序子序列两两合并
        for (i = 0; i + 2 * h - 1 <= n; i += 2 * h) {
            merge(i, i + h - 1, i + 2 * h - 1, a, b);
        }
        //合并后有剩余的子序列
        if (i + h - 1 < n) {
            //剩余两个子序列，最后一个长度小于h
            merge(i, i + h - 1, n, a, b);
        } else {
            //只剩一个子序列，直接复制
            for (t = i; t <= n; t++) {
                b[t] = a[t];
            }
        }
        show(a);

    }

    /**
     * 合并两个有序序列，都是a的子序列 ：  start->left  +  left + 1 -> right
     *
     * @param start 子序列起始下标
     * @param left  前h个元素的最大下标
     * @param right 后h个元素的最大下标
     * @param a     待合并数组
     * @param b     合并后的数组
     */
    private void merge(int start, int left, int right, Comparable[] a, Comparable[] b) {
        int i = start;
        int j = left + 1;
        int k = start;

        while (i <= left && j <= right) {
            b[k++] = (lessThan(a[i], a[j])) ? a[i++] : a[j++];
        }
        //把未处理完的剩余部分复制到B
        while (i <= left) {
            b[k++] = a[i++];
        }
        while (j <= right) {
            b[k++] = a[j++];
        }

    }


}
