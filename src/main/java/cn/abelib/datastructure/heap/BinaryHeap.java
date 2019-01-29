package cn.abelib.datastructure.heap;

import cn.abelib.datastructure.linear.list.ArrayList;
import cn.abelib.util.commons.Constant;

import java.util.Comparator;


/**
 * @Author: abel.huang
 * @Date: 2019-01-28 21:48
 */
public class BinaryHeap<T extends Comparable<T>> {
    private ArrayList<T> array;
    private Comparator<T> comparator;

    public BinaryHeap() {
        this(Constant.DEFAULT_CAPACITY, Comparator.naturalOrder());
    }

    public BinaryHeap(int capacity) {
        this(capacity, Comparator.naturalOrder());
    }

    public BinaryHeap(int capacity, Comparator<T> comparator) {
        this.array = new ArrayList<>();
        this.comparator = comparator;
    }

    public int size() {
        return array.size;
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index << 2 + 1;
    }

    private int rightChild(int index) {
        return index << 2 + 2;
    }
}
