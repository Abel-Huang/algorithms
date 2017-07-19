package com.abel.sort.quick;

import com.abel.sort.BasicSort;
import com.abel.sort.InsertionSort;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by huangjinajin on 2017/7/18.
 */
public class QuickSort extends BasicSort {
    @Override
    public void sort(Comparable[] a) {
        Collections.shuffle(Arrays.asList(a));
        sort(a, 0, a.length - 1);
    }


    private void sort(Comparable []a, int low, int high){
        if (low>=high)
            return;
        int p=partition(a, low, high);
        sort(a, low, p-1);
        sort(a, p+1, high);
    }

    private int partition(Comparable []a, int low, int high){
        Comparable value=a[low];
        int i=low, j=high+1;
        while (true){
            while(less(a[++i], value))
                if (i==high)
                    break;
            while(less(value, a[--j]))
                if (j==low)
                    break;
            if (i>=j)
                break;
            else
                exchange(a, i ,j);
        }
        exchange(a, low, j);
        return j;
    }

    public static void main(String args[]){
        Integer[] a={2,3,4,5,6,1,10,9,8,12,2,1};
//        SelectionSort selection=new SelectionSort();
//        selection.sort(a);
//        if(selection.isSorted(a))
//            selection.show(a);
//        String[] a={"as","bc","de","zz","jk","hk","hk","hj"};
        MoreQuickSort quick=new MoreQuickSort();
        quick.sort(a);
        if(quick.isSorted(a))
            quick.show(a);
    }
}
