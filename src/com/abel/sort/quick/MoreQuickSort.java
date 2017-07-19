package com.abel.sort.quick;

import com.abel.sort.BasicSort;
import com.abel.sort.InsertionSort;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by huangjinajin on 2017/7/19.
 * 对快速排序的改进算法
 */
public class MoreQuickSort extends BasicSort {
    private final int TRANS_ARG=5;

    public void sort(Comparable[] a) {
        Collections.shuffle(Arrays.asList(a));
        sort(a, 0, a.length - 1);
    }

    //   在内部较小数组式，用插入排序代替快速排序
    //   使用三向切分，提升重复元素的排序速度
    private void sort(Comparable []a, int low, int high){
        if (high<=low+TRANS_ARG){
            new InsertionSort().sort(a, low, high);
            return;
        }
        int left=low, right=high, i=low+1;
        Comparable value=a[low];
        while(i<=right){
            int cmp=a[i].compareTo(value);
            if (cmp < 0)
                exchange(a, left++, i++);
            else if (cmp > 0)
                exchange(a, i, right--);
            else
                i++;
        }
        sort(a, low, left-1);
        sort(a, right+1, high);
    }



}
