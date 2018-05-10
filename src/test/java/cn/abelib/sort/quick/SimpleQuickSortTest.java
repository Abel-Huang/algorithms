package cn.abelib.sort.quick;


import cn.abelib.commons.RandomData;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by abel-huang on 2017/7/19.
 *
 */
public class SimpleQuickSortTest {
    @Test
    public void quickSortTest(){
        int[] array = RandomData.randIntArray(10, 10);
        Arrays.stream(array).forEach(System.err::print);
        SimpleQuickSort simpleQuickSort = new SimpleQuickSort();
        simpleQuickSort.sort(array, 0, array.length-1);
        System.err.println();
        Arrays.stream(array).forEach(System.err::print);

    }

}
