package algorithm;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 二分查找，需要序列有序
 * Created by lzj on 2017/5/19.
 */
public class BinarySearch {

    /**
     *
     */
    @Test
    public void test01() throws Exception {

        int[] a = new int[]{1, 2, 3, 4, 5};
        assertEquals(0, binarySearch(a, 0, a.length - 1, 1));
        assertEquals(1, binarySearch(a, 0, a.length - 1, 2));
        assertEquals(2, binarySearch(a, 0, a.length - 1, 3));
        assertEquals(3, binarySearch(a, 0, a.length - 1, 4));
        assertEquals(4, binarySearch(a, 0, a.length - 1, 5));

        assertEquals(0, binarySearch2(a, 1));
        assertEquals(1, binarySearch2(a, 2));
        assertEquals(2, binarySearch2(a, 3));
        assertEquals(3, binarySearch2(a, 4));
        assertEquals(4, binarySearch2(a, 5));

    }

    //递归
    int binarySearch(int[] a, int low, int high, int value) {
        int mid = (low + high) / 2;
        if (a[mid] == value) {
            return mid;
        }
        if (a[mid] > value) {
            return binarySearch(a, low, mid - 1, value);
        }
        if (a[mid] < value) {
            return binarySearch(a, mid + 1, high, value);
        }
        return -1;
    }

    //非递归
    int binarySearch2(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            }
            if (a[mid] > value) {
                high = mid - 1;
            }
            if (a[mid] < value) {
                low = mid + 1;
            }
        }
        return -1;
    }


}
