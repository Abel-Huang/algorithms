package cn.abelib.sort.heap;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by abel on 2018/5/9.
 *  最小堆的单元测试类
 */
public class MinHeapTest {
    @Test
    public void insertTest(){
        MinHeap minHeap = new MinHeap();
        minHeap.insertList(Arrays.asList(5, 1, 3, 4, 2, 7, 6, 9 ,8));
       // minHeap.traversal();
        minHeap.insert(0);
        minHeap.traversal();
    }

    @Test
    public void delMinTest(){
        MinHeap minHeap = new MinHeap();
        minHeap.insertList(Arrays.asList(5, 1, 3, 4, 2, 7, 6, 9 ,8));
        System.err.println(minHeap.delMin());
        System.err.println(minHeap.delMin());
        minHeap.traversal();
    }
}
