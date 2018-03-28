package cn.abelib.utils.sort;

import cn.abelib.common.ResultTest;
import cn.abelib.common.TestException;
import cn.abelib.common.data.EnumType;
import cn.abelib.common.data.EnumSort;
import cn.abelib.common.StdIO;

/**
 * Created by abel-huang on 2017/7/19.
 * A graph cn.abelib.common.data.algorithm class for all Sort Alg
 */
public class SortTest {
    public static void main(String [] args){
        ResultTest rstTest = new ResultTest();
        try{
            rstTest.testSort(10, 10, EnumType.DOUBLE_TYPE, EnumSort.INSERT_SORT);
            rstTest.testSort(10, 10, EnumType.DOUBLE_TYPE, EnumSort.SELECTION_SORT);
            rstTest.testSort(10, 10, EnumType.DOUBLE_TYPE, EnumSort.SHELL_SORT);
            rstTest.testSort(10, 10, EnumType.DOUBLE_TYPE, EnumSort.MERGE_SORT_1);
            rstTest.testSort(10, 10, EnumType.DOUBLE_TYPE, EnumSort.MERGE_SORT_2);
            rstTest.testSort(10, 10, EnumType.DOUBLE_TYPE, EnumSort.QUICK_SORT_1);
            rstTest.testSort(10, 10, EnumType.DOUBLE_TYPE, EnumSort.QUICK_SORT_2);
            rstTest.testSort(10, 10, EnumType.DOUBLE_TYPE, EnumSort.HEAP_SORT);
        }catch (TestException te){
            StdIO.println(te.toString());
        }
    }
}
