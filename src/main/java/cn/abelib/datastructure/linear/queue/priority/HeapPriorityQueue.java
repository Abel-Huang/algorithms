package cn.abelib.datastructure.linear.queue.priority;

import cn.abelib.datastructure.heap.BinaryHeap;
import cn.abelib.datastructure.heap.Heap;
import cn.abelib.util.commons.Constant;

import java.util.Comparator;
import java.util.Iterator;

/**
 * @Author: abel.huang
 * @Date: 2019-01-30 01:03
 * 基于二叉堆实现的优先队列，默认为最大优先队列
 */
public class HeapPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {
    private Heap<T> heap;

    public HeapPriorityQueue() {
        this(Constant.DEFAULT_CAPACITY, Comparator.naturalOrder());
    }

    public HeapPriorityQueue(int capacity) {
        this(capacity, Comparator.naturalOrder());
    }

    public HeapPriorityQueue(int capacity,  Comparator<T> comparator) {
        this.heap = new BinaryHeap<>(capacity, comparator);
    }
    @Override
    public void enqueue(T item) {
        heap.add(item);
    }

    @Override
    public T dequeue() {
        return heap.removeTop();
    }

    @Override
    public T peek() {
        return heap.getTop();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public Iterator<T> iterator() {
        return heap.iterator();
    }
}
