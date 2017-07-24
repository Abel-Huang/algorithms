package com.main.basic.test;

import com.main.basic.data.EnumSort;
import com.main.basic.data.EnumType;
import com.main.basic.util.*;
import com.main.sort.BasicSort;
import com.main.sort.InsertionSort;
import com.main.sort.SelectionSort;
import com.main.sort.ShellSort;
import com.main.sort.merge.MergeSortBT;
import com.main.sort.merge.MergeSortTB;
import com.main.sort.quick.MoreQuickSort;
import com.main.sort.quick.QuickSort;

/**
 * Created by huangjinajin on 2017/7/19.
 * 用于测试结果，包括结果正确性以及程序耗时
 */
public class ResultTest{
    private void testInfo(Class objClass){
//        StdIO.println(objClass.);
    }

    public void testSort(int range, int size, EnumType et,  EnumSort es){
        Comparable [] a;
        switch (et){
            case INTEGER_TYPE:
                a = RandomData.randIntegerArray(range, size);
                break;
            case DOUBLE_TYPE:
                a = RandomData.randDoubleArray(range, size);
                break;
            case STRING_TYPE:
                a = RandomData.randStrArray(range, size);
                break;
            case CHARACTER_TYPE:
                a = RandomData.randCharArray(range, size);
                break;
            default:
                a = null;
        }
        if (a == null)
            return;
        BasicSort sort;
        switch (es){
            case INSERT_SORT:
                sort=new InsertionSort();
                break;
            case SELECTION_SORT:
                sort=new SelectionSort();
                break;
            case SHELL_SORT:
                sort=new ShellSort();
                break;
            case MERGE_SORT_1:
                sort=new MergeSortBT();
                break;
            case MERGE_SORT_2:
                sort=new MergeSortTB();
                break;
            case QUICK_SORT_1:
                sort=new QuickSort();
                break;
            case QUICK_SORT_2:
                sort=new MoreQuickSort();
                break;
            default:
                sort=null;
                break;

        }
        if(sort == null){
            return;
        }
        Timer timer = new Timer();
        sort.sort(a);
        StdIO.print("Test: "+a.getClass().getSimpleName());
        StdIO.println("Runtime: " + timer.timeGoesBy());
        if(sort.isSorted(a))
            sort.show(a);
    }

    private void testUtil(){

    }

    private void testSearch(){

    }
}
