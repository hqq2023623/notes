package com.zj.algorithm;

public class Searcher {

    public static void main(String[] args) {

        int[] sortedValues = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int position = Searcher.binSearch(sortedValues, 0, sortedValues.length,
                2);

        System.out.println(position);

    }

    // 1.二分查找 == 二叉搜索, 返回的结果是下标, 找不到则返回-1
    public static int binSearch(int[] sortedValues, int first, int last,
                                int target) {
        // 数组的中点下标
        int mid;
        // 数组的中心值
        int midValue;
        while (first < last) {
            // 第一次是指定范围的中心
            mid = (first + last) / 2;
            midValue = sortedValues[mid];
            // 如果中点值 == 目标值则直接返回
            if (target == midValue) {
                return mid;
                // 如果大于则从mid+1 到last进行二分
            } else if (target > midValue) {
                first = mid + 1;
                // 小于则从first 到mid进行二分
            } else {
                last = mid;
            }
        }
        return -1;
    }

}
