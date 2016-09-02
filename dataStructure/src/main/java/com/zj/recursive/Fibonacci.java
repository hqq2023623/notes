package com.zj.recursive;

public class Fibonacci {

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    // 不使用递归实现的Fibonacci
    public static int fibIterator(int n) {
        int after = 1, pre = 0, current = 0;
        int i;

        if (n <= 1) {
            return n;
        } else {
            for (i = 2; i <= n; i++) {
                current = after + pre;
                pre = after;
                after = current;
            }
            return current;
        }
    }

}
