package com.zj.recursive;

import static org.junit.Assert.*;
import org.junit.Test;

public class Recursive01 {

	// 1.求n的阶乘
	public int factorial(int n) {

		if (n == 1) {
			return n;
		} else {
			return n * factorial(n - 1);
		}

	}

	@Test
	public void testFactorial() {

		assertEquals(factorial(1), 1);
		assertEquals(factorial(5), 120);

	}

	// 2.接受一个十进制的数n和一个基数b, 计算出其对应进制的String表示
	// 根据累除法获得的值刚好为目标值的倒序排列
	public String baseString(int n, int base) {

		String str = "";
		String digitChar = "0123456789abcdef";

		// 如果n是0,就返回空字符串
		if (n == 0) {
			return "";
		} else {
			// 获得n/b对应的字符
			str = baseString(n / base, base);
			// 倒序拼接字符
			return str + digitChar.charAt(n % base);
		}
	}

	@Test
	public void testBaseString() {

		assertEquals("137", baseString(95, 8));
		assertEquals("100", baseString(100, 10));

	}

	// 输入一个数字,给出它的字符串表示
	public static String numToNames(int n) {
		if (n < 10) {
			return numToName(n);
		} else {
			return numToNames(n / 10) + " " + numToName(n % 10);
		}
	}

	private static String numToName(int n) {
		String value = "";
		switch (n) {
		case 0:
			value = "zero";
			break;
		case 1:
			value = "one";
			break;
		case 2:
			value = "two";
			break;
		case 3:
			value = "three";
			break;
		case 4:
			value = "four";
			break;
		case 5:
			value = "five";
			break;
		case 6:
			value = "six";
			break;
		case 7:
			value = "seven";
			break;
		case 8:
			value = "eight";
			break;
		case 9:
			value = "nine";
			break;
		default:
			break;
		}
		return value;
	}

	@Test
	public void test02() {

		System.out.println(numToNames(123));

	}

	/**
	 * 在Arrays和GenericUtil里实现了的二分查询binSearch(),现在我们要使用递归的思想来实现它们:
	 * 该方法接受一个数组arr(用索引first和last来描述一个索引)和一个target值,并且扫描查找匹配的列表. 这个方法返回匹配的索引,
	 * 或者在没有匹配的情况下返回-1. 使用分治侧率实现一个递归形式的二分查询搜索算法.
	 * 
	 * @param <T>
	 *            泛型类型T
	 * @param arr
	 *            反省类型数组
	 * @param first
	 *            数组arr的头索引
	 * @param last
	 *            数组arr的尾索引
	 * @param target
	 *            搜索的目标值
	 * @return
	 */
	public static <T extends Comparable<? super T>> int binSearch(T[] arr,
			int first, int last, T target) {
		int mid = (first + last) / 2;
		if (first < last) { // 运行条件1
			if (arr[mid].compareTo(target) > 0) { // 停止条件1
				return binSearch(arr, first, mid, target); // 递归步骤1
			} else if (arr[mid].compareTo(target) < 0) { // 停止条件2
				return binSearch(arr, mid + 1, last, target); // 递归步骤2
			} else {
				return mid; // 返回步骤1
			}
		} else if (first == last) { // 运行条件2
			if (arr[mid].compareTo(target) == 0) { // 停止条件1
				return mid; // 返回步骤1
			} else {
				return -1; // 返回步骤2
			}
		} else { // 运行条件3
			return -1; // 返回步骤2
		}
	}

}
