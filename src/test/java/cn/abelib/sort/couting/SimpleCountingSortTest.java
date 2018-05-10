package cn.abelib.sort.couting;

import cn.abelib.commons.RandomData;
import cn.abelib.sort.counting.SimpleCountingSort;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by abel on 2018/5/11.
 */
public class SimpleCountingSortTest {
    @Test
    public void countingSortTest(){
        int[] a = RandomData.randIntArray(1000, 1000);
        SimpleCountingSort countingSort = new SimpleCountingSort();
        countingSort.sort(a);
        Arrays.stream(a).forEach(System.err::println);
    }
}
