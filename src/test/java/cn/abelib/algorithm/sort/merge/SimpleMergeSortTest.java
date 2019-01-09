package cn.abelib.algorithm.sort.merge;


import cn.abelib.util.commons.RandomData;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by abel-huang on 2017/7/19.
 */
public class SimpleMergeSortTest {
    @Test
    public void simpleMergeSort() {
        SimpleMergeSort sort = new SimpleMergeSort();
        int a[] = RandomData.randIntArray(1000, 1000);
        sort.sort(a);
        Arrays.stream(a).forEach(System.err::println);
        System.err.println();
    }
}
