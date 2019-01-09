package cn.abelib.algorithm.sort.quick;


import cn.abelib.algorithm.sort.AbstractSort;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author abel-huang
 * @date 2017/7/18
 */
public class QuickSort extends AbstractSort {
    @Override
    public void sort(Comparable[] a) {
        Collections.shuffle(Arrays.asList(a));
        sort(a, 0, a.length - 1);
    }


    private void sort(Comparable[] a, int low, int high) {
        if (low >= high)
            return;
        int p = partition(a, low, high);
        sort(a, low, p - 1);
        sort(a, p + 1, high);
    }

    private int partition(Comparable[] a, int low, int high) {
        Comparable value = a[low];
        int i = low, j = high + 1;
        while (true) {
            while (less(a[++i], value)) {
                if (i == high) {
                    break;
                }
            }
            while (less(value, a[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            } else {
                exchange(a, i, j);
            }
        }
        exchange(a, low, j);
        return j;
    }
}
