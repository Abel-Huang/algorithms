package cn.abelib.datastructure.heap;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by abel on 2018/5/9.
 * 最大堆的单元测试类
 */
public class MaxBinaryHeapTest {
    @Test
    public void insertTest() {
        MaxBinaryHeap maxBinaryHeap = new MaxBinaryHeap();
        maxBinaryHeap.insertList(Arrays.asList(12, 5, 33));
        maxBinaryHeap.traversal();
    }

    @Test
    public void delMaxTest() {
        MaxBinaryHeap maxBinaryHeap = new MaxBinaryHeap();
        maxBinaryHeap.insertList(Arrays.asList(1, 5, 3, 4, 7, 9, 8, 6, 2));
        maxBinaryHeap.traversal();

        System.err.println(maxBinaryHeap.delMax());
        maxBinaryHeap.traversal();
        System.err.println(maxBinaryHeap.delMax());
        System.err.println(maxBinaryHeap.delMax());
        System.err.println(maxBinaryHeap.delMax());
        System.err.println(maxBinaryHeap.delMax());
    }
}
