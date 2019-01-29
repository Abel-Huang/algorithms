package cn.abelib.datastructure.linear.list;

import cn.abelib.datastructure.linear.Collection;

import java.util.Iterator;

/**
 * @Author: abel-huang
 * @Date: 2018-12-18 23:23
 */
public abstract class AbstractLinkedList<T> implements Collection<T> {
    Node head;
    Node tail;
    int size;

    public abstract void add(T item);

    public abstract T get(int index);

    public abstract int find(T item);

    public abstract boolean contains(T item);

    public abstract void removeElement(T item);

    public abstract T remove(int index);

    public abstract void removeAll();

    @Override
    public int size() {
        return size;
    }

    class Node {
        T item;
        Node next;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
        private Node current = head;
        private int i = size;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            i--;
            return item;
        }

        @Override
        public void remove() {
        }
    }
}
