package cn.abelib.datastructure.linear.queue;

import cn.abelib.util.exception.NoMoreElementException;

import java.util.Iterator;

/**
 * @author abel-huang
 * @date 2017/1/10
 */
public class LinkedQueue<T> implements Queue<T> {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        T item;
        Node next;
    }

    public LinkedQueue() {
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(T item) {
        Node oldLast = tail;
        tail = new Node();
        tail.item = item;
        tail.next = null;
        if (isEmpty()) {
            head = tail;
        } else {
            oldLast.next = tail;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoMoreElementException();
        }
        T item = head.item;
        head = head.next;
        if (isEmpty()) {
            tail = null;
        }
        size--;
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoMoreElementException();
        }
        return head.item;
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
        private Node current = head;

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

        @Override
        public void remove() {
        }
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
}
