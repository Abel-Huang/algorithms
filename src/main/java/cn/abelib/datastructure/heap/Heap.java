package cn.abelib.datastructure.heap;

import cn.abelib.datastructure.linear.Collection;

/**
 * @Author: abel.huang
 * @Date: 2019-01-29 23:32
 * 堆接口
 */
public interface Heap<T extends Comparable<T>> extends Collection<T> {
    void add(T item);

    T getTop();

    T removeTop();

    T replace(T item);
}
