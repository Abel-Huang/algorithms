package cn.abelib.datastructure.linear.queue;

import cn.abelib.datastructure.linear.list.AbstractArray;
import cn.abelib.util.commons.Constant;
import cn.abelib.util.exception.NoMoreElementException;


/**
 * @author abel-huang
 * @date 2016/12/25
 */
public class ArrayListQueue<T> extends AbstractArray<T> implements Queue<T> {
    /**
     * empty construction
     */
    public ArrayListQueue() {
        this(Constant.DEFAULT_CAPACITY);
    }

    /**
     * @param capacity
     */
    public ArrayListQueue(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
    public void enqueue(T item) {
        if (size == data.length) {
            resize(2 * data.length);
        }
        data[size++] = item;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoMoreElementException();
        }
        T item = data[0];
        for (int i = 0; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        --size;
        if (size > 0 && size == data.length / 4) {
            resize(data.length / 2);
        }
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoMoreElementException();
        }
        return data[0];
    }
}
