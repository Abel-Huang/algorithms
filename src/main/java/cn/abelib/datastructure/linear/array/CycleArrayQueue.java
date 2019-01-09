package cn.abelib.datastructure.linear.array;

import cn.abelib.datastructure.linear.Queue;
import cn.abelib.util.commons.Constant;
import cn.abelib.util.exception.NoMoreElementException;

import java.util.Iterator;


/**
 * @Author: abel-huang
 * @Date: 2018-12-17 22:47
 */
public class CycleArrayQueue<T> implements Queue<T> {
    private int head;
    private int tail;
    private T[] data;
    private int size;

    public CycleArrayQueue() {
        this(Constant.DEFAULT_CAPACITY);
    }

    public CycleArrayQueue(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
        tail = 0;
        tail = 0;
    }

    /**
     * resize
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        T[] temp = (T[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            temp[i] = data[(i + head) % data.length];
        }
        data = temp;
        head = 0;
        tail = size;
    }

    @Override
    public void enqueue(T item) {
        if ((tail + 1) % data.length == head) {
            resize(2 * data.length);
        }
        data[tail] = item;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoMoreElementException();
        }
        T item = data[head];
        head = (head + 1) % data.length;
        size--;
        if (size > 0 && size == data.length / 4) {
            resize(data.length / 2);
        }
        return item;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new NoMoreElementException();
        }
        return data[head];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(this.getClass().getSimpleName() + ": size=%d, content=", size));
        sb.append("head [");
        CycleArrayQueue.Itr itr = new CycleArrayQueue.Itr();
        while (itr.hasNext()) {
            sb.append(itr.next());
            if (itr.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new CycleArrayQueue.Itr();
    }

    private class Itr implements Iterator<T> {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public T next() {
            return data[(head + i++) % data.length];
        }

        @Override
        public void remove() {
        }
    }
}
