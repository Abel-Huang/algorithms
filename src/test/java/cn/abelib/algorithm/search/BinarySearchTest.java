package cn.abelib.algorithm.search;

import org.junit.Test;

/**
 * Created by abel on 2016/12/12.
 * 用于测试二分搜索
 */
public class BinarySearchTest {
    @Test
    public void binarySearchTest() {
        int a[] = {1, 2, 4, 6, 8, 10, 12, 16, 20};
        int key = 3;
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.binarySearch(key, a);
        System.err.println(result);
    }
}
