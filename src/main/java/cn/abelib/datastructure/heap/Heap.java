package cn.abelib.datastructure.heap;

/**
 * @Author: abel.huang
 * @Date: 2019-01-29 23:32
 * 堆接口
 */
public interface Heap<T extends Comparable<T>> {
    int size();

    boolean isEmpty();

    void add(T item);

    T getTop();

    T removeTop();

    T replace(T item);
}
