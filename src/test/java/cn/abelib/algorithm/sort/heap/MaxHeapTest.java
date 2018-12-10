package cn.abelib.algorithm.sort.heap;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by abel on 2018/5/9.
 * 最大堆的单元测试类
 */
public class MaxHeapTest {
    @Test
    public void insertTest(){
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insertList(Arrays.asList( 12, 5, 33));
        maxHeap.traversal();
    }
    @Test
    public void delMaxTest(){
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insertList(Arrays.asList( 1, 5, 3, 4, 7, 9 ,8, 6, 2));
         maxHeap.traversal();

        System.err.println(maxHeap.delMax());
        maxHeap.traversal();
        System.err.println(maxHeap.delMax());
        System.err.println(maxHeap.delMax());
        System.err.println(maxHeap.delMax());
        System.err.println(maxHeap.delMax());
    }
}
