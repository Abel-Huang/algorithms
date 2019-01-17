package cn.abelib.datastructure.tree.segment;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * @Author: abel.huang
 * @Date: 2019-01-16 01:32
 */
public class SegmentTree<T> {
    private T[] tree;
    private T[] data;
    private BiFunction<T, T, T> biFunction;

    public SegmentTree(T[] a, BiFunction<T, T, T> biFunction) {
        this.data =Arrays.copyOf(a, a.length);
        this.biFunction = biFunction;
        this.tree = (T[]) new Object[4 * a.length];
        build(0, 0,data.length - 1);
    }

    /**
     *  递归构建线段树
     * @param treeIndex
     * @param l
     * @param r
     */
    private void build(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int mid = (r - l) / 2 + l;
        int leftChild = getLeft(treeIndex);
        int rightChild = getRight(treeIndex);
        build(leftChild, l, mid);
        build(rightChild, mid + 1, r);
        tree[treeIndex] = biFunction.apply(tree[leftChild], tree[rightChild]);
    }

    /**
     *  查询
     * @param rangeL
     * @param rangeR
     * @return
     */
    public T query(int rangeL, int rangeR) {
        if (rangeL < 0 || rangeL >= data.length || rangeR < 0 || rangeR >= data.length || rangeL > rangeR) {
            throw new IllegalArgumentException("Un support arguments!");
        }
        return query(0, 0, data.length - 1, rangeL, rangeR);
    }

    /**
     *
     * @param treeIndex
     * @param l
     * @param r
     * @param rangeL
     * @param rangeR
     * @return
     */
    private T query(int treeIndex, int l, int r, int rangeL, int rangeR) {
        if (rangeL == l && rangeR == r) {
            return tree[treeIndex];
        }
        int mid = (r - l) / 2 + l;
        int leftChild = getLeft(treeIndex);
        int rightChild = getRight(treeIndex);
        if (rangeR <= mid) {
            return query(leftChild, l, mid, rangeL,  rangeR);
        } else if (rangeL >= mid + 1) {
            return query(rightChild, mid + 1, r, rangeL, rangeR);
        }
        // 查询范分布在 mid 两边
        return biFunction.apply(query(leftChild, l, mid, rangeL, mid),
                query(rightChild, mid + 1, r, mid + 1, rangeR));
    }

    public int size(){
        return data.length;
    }

    public T get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    /**
     *  更新
     * @param index
     * @param item
     */
    public void set(int index, T item) {
        if (index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException();
        }
        set(0, 0, data.length - 1, index, item);
    }

    private void set(int treeIndex, int l, int r, int index, T item) {
        if (l == r) {
            tree[treeIndex] = item;
            return;
        }
        int mid = (r - l) / 2 + l;
        int leftChild = getLeft(treeIndex);
        int rightChild = getRight(treeIndex);
        if (index >= mid + 1) {
            set(rightChild, mid + 1, r, index, item);
        } else if (index <= mid) {
            set(leftChild, l, mid, index, item);
        }
        tree[treeIndex] = biFunction.apply(tree[leftChild], tree[rightChild]);
    }

    /**
     * 获取左孩子的索引
     * @param index
     * @return
     */
    private int getLeft(int index) {
        return 2 * index + 1;
    }

    /**
     * 获取右孩子的索引
     * @param index
     * @return
     */
    private int getRight(int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + Arrays.toString(tree);
    }
}
