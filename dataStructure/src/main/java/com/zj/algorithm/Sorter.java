package com.zj.algorithm;

public class Sorter {

    public static void main(String[] args) {

        int[] values = {100, 20, 30, 60, 5, 4, 2, 7};

        System.out.println("排序前: ");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }

        System.out.println();

        // Sorter.selectionSotrDesc(values);
        // Sorter.bidSelectionSort(values);
        // Sorter.bubbleSort(values);
        Sorter.exchangeSort(values);

        System.out.println("排序后");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }

    }

    // 1.选择排序, 元素按升序排列
    public static void selectionSotr(int[] values) {
        // 每次遍历中最小的数的下标
        int smallIndex;
        // pass表示当前要存放最小数的下标
        int pass, j;
        int n = values.length;

        for (pass = 0; pass < n - 1; pass++) {
            // 首先假定当前遍历的首元素下标为最小数下标
            smallIndex = pass;
            // 找出当前次遍历中最小数的下标
            // j从values[pass+1] 开始到 values[n-1]结束
            for (j = pass + 1; j < n; j++) {
                if (values[j] < values[smallIndex]) {
                    smallIndex = j;
                }
            }
            // 交换pass和查找到的下标对应位置的数值
            swap(values, pass, smallIndex);
        }

    }

    // 3.双向选择排序
    public static void bidSelectionSort(int[] values) {

        int n = values.length;

        for (int i = 1; i <= n / 2; i++) {
            // 先确定此次遍历首尾元素的大小
            if (values[i - 1] > values[n - i]) {
                swap(values, i - 1, n - i);
            }
            // 比较两端的数和中间的数的大小
            for (int j = i; j < n - i; j++) {
                // 如果小于第一个数就交换位置
                if (values[j] < values[i - 1]) {
                    swap(values, j, i - 1);
                    // 如果大于最后一个数就交换位置
                } else if (values[j] > values[n - i]) {
                    swap(values, j, n - i);
                }
            }
            System.out.println("第" + i + "次遍历: ");
            for (int k = 0; k < values.length; k++) {
                System.out.print(values[k] + " ");
            }
            System.out.println();

        }

    }

    // 3.冒泡排序
    public static void bubbleSort(int[] values) {

        int n = values.length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (values[j] > values[j + 1]) {
                    swap(values, j, j + 1);
                }
            }
            /*System.out.println("第" + i + "次遍历: ");
            for (int k = 0; k < values.length; k++) {
				System.out.print(values[k] + " ");
			}
			System.out.println();*/
        }

    }

    // 4.基本的交换排序
    public static void exchangeSort(int[] values) {

        int n = values.length;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                if (values[i] > values[j]) {
                    swap(values, i, j);
                }
            }
            System.out.println("第" + i + "次遍历: ");
            for (int k = 0; k < values.length; k++) {
                System.out.print(values[k] + " ");
            }
            System.out.println();

        }

    }

    // 交换数组中两个数
    public static void swap(int values[], int a, int b) {
        int temp = values[a];
        values[a] = values[b];
        values[b] = temp;
    }

}
