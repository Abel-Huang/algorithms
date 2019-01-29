package cn.abelib.datastructure.heap;

import org.junit.Test;
import java.util.Arrays;

/**
 * Created by abel on 2018/5/9.
 * 最小堆的单元测试类
 */
public class MinBinaryHeapTest {
    @Test
    public void insertTest() {
        MinBinaryHeap minBinaryHeap = new MinBinaryHeap();
        minBinaryHeap.insertList(Arrays.asList(5, 1, 3, 4, 2, 7, 6, 9, 8));
        // minBinaryHeap.traversal();
        minBinaryHeap.insert(0);
        minBinaryHeap.traversal();
    }

    @Test
    public void delMinTest() {
        MinBinaryHeap minBinaryHeap = new MinBinaryHeap();
        minBinaryHeap.insertList(Arrays.asList(5, 1, 3, 4, 2, 7, 6, 9, 8));
        System.err.println(minBinaryHeap.delMin());
        System.err.println(minBinaryHeap.delMin());
        minBinaryHeap.traversal();
    }
}
