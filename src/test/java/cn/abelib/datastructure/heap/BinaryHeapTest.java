package cn.abelib.datastructure.heap;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;


/**
 * @Author: abel.huang
 * @Date: 2019-01-30 00:08
 */
public class BinaryHeapTest {
    private Heap<Integer> binaryHeap;

    @Before
    public void init() {
        binaryHeap = new BinaryHeap<>(10, Comparator.<Integer>reverseOrder());
        System.out.println(binaryHeap.isEmpty());
        binaryHeap.add(4);
        binaryHeap.add(2);
        binaryHeap.add(3);
        binaryHeap.add(1);

    }

    @Test
    public void test() {
        System.out.println(binaryHeap.size());
        System.out.println(binaryHeap.isEmpty());
    }

    @Test
    public void getTopTest() {
        System.out.println(binaryHeap.getTop());
        System.out.println(binaryHeap.size());
    }

    @Test
    public void delTopTest() {
        System.out.println(binaryHeap.removeTop());
        System.out.println(binaryHeap.size());
        System.out.println(binaryHeap.getTop());
    }
}
