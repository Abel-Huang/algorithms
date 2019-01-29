package cn.abelib.datastructure.heap;

import cn.abelib.datastructure.linear.list.ArrayList;
import cn.abelib.util.commons.Constant;

import java.util.Comparator;
import java.util.NoSuchElementException;


/**
 * @Author: abel.huang
 * @Date: 2019-01-28 21:48
 * 基于动态数组实现的通用二叉堆，默认是最大堆，
 * 可通过自定义 Comparator 实现最小堆
 */
public class BinaryHeap<T extends Comparable<T>> extends AbstractBinaryHeap<T> {
    private ArrayList<T> array;
    private Comparator<T> comparator;

    public BinaryHeap() {
        this(Constant.DEFAULT_CAPACITY, Comparator.naturalOrder());
    }

    public BinaryHeap(int capacity) {
        this(capacity, Comparator.naturalOrder());
    }

    public BinaryHeap(int capacity, Comparator<T> comparator) {
        this.array = new ArrayList<>(capacity);
        this.comparator = comparator;
    }

    public BinaryHeap(ArrayList<T> array) {
        this(array, Comparator.naturalOrder());
    }

    public BinaryHeap(ArrayList<T> array, Comparator<T> comparator) {
        this.array =array;
        this.comparator = comparator;
        heapify();
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     *  插入新元素，并将其上浮到
     *  指定的位置
     * @param item
     */
    @Override
    public void add(T item) {
        array.add(item);
        swim(array.size() - 1);
    }

    /**
     *  取出堆顶的元素
     */
    @Override
    public T getTop() {
        if (array.size() == 0) {
            throw new NoSuchElementException();
        }
        return array.get(0);
    }

    /**
     *  删除堆顶的元素
     * @return
     */
    @Override
    public T removeTop() {
        T item = getTop();
        swap(0, array.size() - 1);
        array.removeLast();
        sink(0);
        return item;
    }

    /**
     *  返回原来的堆顶值，
     *  并插入一个新的值
     * @param item
     * @return
     */
    @Override
    public T replace(T item) {
        T top = getTop();
        array.set(0, item);
        sink(0);
        return top;
    }

    /**
     *  如果节点与父节点位置不正确，
     *  将二者的位置进行交换, 直到
     *  将其放到合适的位置
     * @param k
     */
    @Override
    public void swim(int k) {
        while (k > 0 && comparator.compare(array.get(parent(k)), array.get(k)) < 0) {
            swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     *  将节点与其左右孩子进行比较，
     *  如果该节点比其孩子小，该节点
     *  会和较大的那个元素进行交换，
     *  直到将其放到合适的位置
     * @param k
     */
    @Override
    public void sink(int k) {
        while (leftChild(k) < array.size()) {
            int j = leftChild(k);
            // 有右孩子，且右孩子比左孩子大
            if (j + 1 < array.size() && comparator.compare(array.get(j + 1), array.get(j)) > 0) {
               j = rightChild(k);
            }
            // 此时 j 就是 k 左右孩子中较大的那一个
            if (comparator.compare(array.get(k), array.get(j)) > 0) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    /**
     *  将数组堆化
     */
    @Override
    protected void heapify() {
        for (int i = parent(array.size() - 1); i >= 0; i ++) {
            sink(i);
        }
    }

    /**
     *  交换数组中对应的元素
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        T temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
