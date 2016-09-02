package com.zj.sort;

import org.junit.Before;
import org.junit.Test;

import algorithm.Sorter;

public class Sorter02 {

	Integer[] values;
	String[] strList;

	@Before
	public void setUp() {
		values = new Integer[] { 50, 41, 61, 51, 93, 70, 57, 93, 95, 55 };
		strList = new String[] { "Dallas", "Akron", "Wausau", "Phoenix",
				"Fairbanks" };
	}

	// 1.插入排序
	public static <T extends Comparable<? super T>> void insertionSort(
			T[] values) {

		int i, j, n = values.length;
		T target;
		for (i = 1; i < n; i++) {
			j = i;
			target = values[i];
			while (j > 0 && target.compareTo(values[j - 1]) < 0) {
				values[j] = values[j - 1];
				j--;
			}
			values[j] = target;
		}
	}

	@Test
	public void testInsertion() {
		System.out.println("排序前: ");
		for (int i = 0; i < values.length; i++) {
			System.out.print(values[i] + " ");
		}

		System.out.println();

		Sorter02.insertionSort(values);

		System.out.println("排序后");
		for (int i = 0; i < values.length; i++) {
			System.out.print(values[i] + " ");
		}
	}

	// 2. 归并排序
	private static void mergeSort(Object[] arr, Object[] tempArr, int first,
			int last) {
		// 如果不是只有一个元素(只有一个元素即自动排序好了)就继续执行
		if (first + 1 < last) {
			int midpt = (first + last) / 2;
			mergeSort(arr, tempArr, first, midpt);
			mergeSort(arr, tempArr, midpt, last);

			// 如果是已经排序好的, 如(只有一个元素,从一个元素开始合并好的子数组)直接返回合并
			if (((Comparable) arr[midpt - 1]).compareTo(arr[midpt]) <= 0) {
				return;
			}
			// A,B分别表示上下子数组, C为临时数组
			int indexA, indexB, indexC;
			indexA = first;
			indexB = midpt;
			indexC = first;

			while (indexA < midpt && indexB < last) {
				// 从first和mid开始, 对比两个子数组的元素, 把较小的元素保存到临时数组, 并且对应的下标+1
				if (((Comparable) arr[indexA]).compareTo(arr[indexB]) < 0) {
					tempArr[indexC] = arr[indexA];
					indexA++;
				} else {
					tempArr[indexC] = arr[indexB];
					indexB++;
				}
				// 临时数组下标也要+1
				indexC++;
			}

			// 把A或者B剩余的元素添加到临时数组的尾部, 此时A或者B的元素已经完全添加到临时数组
			while (indexA < midpt) {
				tempArr[indexC] = arr[indexA];
				indexA++;
				indexC++;
			}
			while (indexB < last) {
				tempArr[indexC] = arr[indexB];
				indexB++;
				indexC++;
			}

			for (int i = first; i < last; i++) {
				arr[i] = tempArr[i];
			}

		}
	}

	@Test
	public void testMergeSort() {

		System.out.println("排序前: ");
		for (int i = 0; i < values.length; i++) {
			System.out.print(values[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < strList.length; i++) {
			System.out.print(strList[i] + " ");
		}

		System.out.println();

		Sorter02.mergeSort(values, values.clone(), 0, values.length);
		Sorter02.mergeSort(strList, strList.clone(), 0, strList.length);

		System.out.println("排序后");
		for (int i = 0; i < values.length; i++) {
			System.out.print(values[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < strList.length; i++) {
			System.out.print(strList[i] + " ");
		}

	}

}
