package cn.abelib.datastructure.heap;

/**
 * @Author: abel.huang
 * @Date: 2019-01-29 23:32
 *  基于数组的二叉堆
 */
public abstract class AbstractBinaryHeap<T extends Comparable<T>> implements Heap<T>{
    protected int parent(int index) {
        // 根节点返回本身
        if (index == 0) {
            return 0;
        }
        return (index - 1) / 2;
    }

    protected int leftChild(int index) {
        return index * 2 + 1;
    }

    protected int rightChild(int index) {
        return index * 2 + 2;
    }

    protected abstract void swim(int k);

    protected abstract void sink(int k);

    protected abstract void heapify();
}
