package cn.abelib.datastructure.linear.list;

import cn.abelib.datastructure.linear.Collection;

import java.util.Iterator;

/**
 * @Author: abel-huang
 * @Date: 2018-12-11 22:54
 */
public abstract class AbstractArray<T> implements Collection<T> {
    public T[] data;
    public int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * resize
     *
     * @param capacity
     */
    public void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    public void set(int index, T item) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        data[index] = item;
    }

    public int capacity() {
        return data.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(this.getClass().getSimpleName() + ": size=%d, content=", size));
        sb.append("[");
        Itr itr = new Itr();
        while (itr.hasNext()) {
            sb.append(itr.next());
            if (itr.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public T next() {
            return data[i++];
        }

        @Override
        public void remove() {
        }
    }
}
