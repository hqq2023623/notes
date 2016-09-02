package com.zj.sort;

public class QuickSort {

    public static <T extends Comparable<? super T>> void quickSort(T[] arr) {
        qsort(arr, 0, arr.length);
    }

    private static <T extends Comparable<? super T>> void qsort(T[] arr,
                                                                int first, int last) {

        int pivotLoc;
        T temp;

        if (last - first <= 1) {
            return;
        } else if (last - first == 2) {

            if (arr[last - 1].compareTo(arr[first]) < 0) {
                temp = arr[last - 1];
                arr[last - 1] = arr[first];
                arr[first] = temp;
            }
            return;

        } else {
            pivotLoc = pivotIndex(arr, first, last);
            qsort(arr, first, pivotLoc);
            qsort(arr, pivotLoc + 1, last);
        }

    }

    public static <T extends Comparable<? super T>> int pivotIndex(T[] arr,
                                                                   int first, int last) {
        int mid, scanUp, scanDown;
        T pivot, temp;

        if (first == last) {
            return last;
        } else if (first == last - 1) {
            return first;
        } else {
            mid = (last + first) / 2;
            pivot = arr[mid];

            arr[mid] = arr[first];
            arr[first] = pivot;

            scanUp = first + 1;
            scanDown = last - 1;

            for (; ; ) {
                while (scanUp <= scanDown && arr[scanUp].compareTo(pivot) < 0) {
                    scanUp++;
                }
                while (pivot.compareTo(arr[scanDown]) < 0) {
                    scanDown--;
                }
                if (scanUp >= scanDown) {
                    break;
                }

                temp = arr[scanUp];
                arr[scanUp] = arr[scanDown];
                arr[scanDown] = temp;

                scanUp++;
                scanDown--;
            }

            arr[first] = arr[scanDown];
            arr[scanDown] = pivot;
            return scanDown;

        }
    }

}
