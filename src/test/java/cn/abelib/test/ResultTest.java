package cn.abelib.test;

import cn.abelib.util.RandomData;
import cn.abelib.util.StdIO;
import cn.abelib.util.Timer;
import cn.abelib.util.data.ConstantData;
import cn.abelib.util.data.EnumSort;
import cn.abelib.util.data.EnumType;
import cn.abelib.sort.BasicSort;
import cn.abelib.sort.InsertionSort;
import cn.abelib.sort.SelectionSort;
import cn.abelib.sort.merge.MergeSortBT;
import cn.abelib.sort.merge.MergeSortTB;
import cn.abelib.sort.priority.heap.HeapSort;
import cn.abelib.sort.quick.MoreQuickSort;
import cn.abelib.sort.quick.QuickSort;
import cn.abelib.sort.ShellSort;

/**
 * Created by huangjinajin on 2017/7/19.
 * ���ڲ��Խ�������������ȷ���Լ������ʱ
 */
public class ResultTest{
    /**
     * @param obj
     */
    private void testInfo(Object obj){
        StdIO.println("Test class: "+obj.getClass().getSimpleName());
    }

    /**
     * @param range
     * @param size the size of array
     * @param et   the type of data
     * @param es   the class of sort
     */
    public void testSort(int range, int size, EnumType et, EnumSort es) throws TestException{
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
            case HEAP_SORT:
                sort=new HeapSort();
                break;
            default:
                sort=null;
                break;

        }
        if(sort == null){
            return;
        }
        testInfo(sort);
        Timer timer = new Timer();
        sort.sort(a);
        StdIO.println("Runtime: " + timer.timeGoesBy());
        if(sort.isSorted(a))
            sort.show(a);
        else
            throw new TestException(ConstantData.SORT_ERROR_MSG);
    }

    private void testUtil(){

    }

    private void testSearch(){

    }
}
