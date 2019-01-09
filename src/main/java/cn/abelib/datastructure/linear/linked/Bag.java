package cn.abelib.datastructure.linear.linked;

import cn.abelib.datastructure.linear.Collection;

import java.util.Iterator;

/**
 * @author abel-huang
 * @date 2016/12/25
 */
public class Bag<T> implements Collection<T> {
    private Node first;
    private int size;

    private class Node {
        T item;
        Node next;
    }

    public Bag() {
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
        }
    }
}
