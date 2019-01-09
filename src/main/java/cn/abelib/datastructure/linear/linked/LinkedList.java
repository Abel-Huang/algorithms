package cn.abelib.datastructure.linear.linked;


import cn.abelib.util.exception.NoMoreElementException;

import java.util.Iterator;

/**
 * @Author: abel-huang
 * @Date: 2017/1/11
 * This is a linked list
 */
public class LinkedList<T> extends AbstractLinkedList<T> {
    public LinkedList() {
        super();
    }

    @Override
    public void add(T item) {
        Node oldNow = tail;
        tail = new Node();
        tail.item = item;
        tail.next = null;
        if (size == 0) {
            head = tail;
        } else {
            oldNow.next = tail;
        }
        size++;
    }

    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(item);
            return;
        }
        Node newNode = new Node();
        newNode.item = item;
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        Node tmp = head;
        while (true) {
            if (index == 1) {
                newNode.next = tmp.next;
                tmp.next = newNode;
                size++;
                return;
            }
            tmp = tmp.next;
            index--;
        }
    }

    // todo

    public void set(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        temp.item = item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        Node temp = head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        return temp.item;
    }

    /**
     * 删除尾部元素
     *
     * @return
     */
    public T delTail() {
        if (size < 1) {
            throw new NullPointerException("No more Item in this list");
        }
        if (size == 1) {
            T result = head.item;
            head = null;
            tail = null;
            size = 0;
            return result;
        }
        T item = tail.item;
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        tail = temp;
        temp.next = null;
        size--;
        return item;
    }

    @Override
    public int find(T item) {
        int index = -1;
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            index++;
            if (item == iterator.next()) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(T item) {
        return find(item) != -1;
    }

    @Override
    public void removeElement(T item) {
        int index = find(item);
        if (index == -1) {
            throw new NoMoreElementException();
        }
        remove(index);
    }

    @Override
    public void removeAll() {
        head = tail;
        size = 0;
    }

    /**
     * 完全错误
     *
     * @param index
     * @return
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size || size == 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            T item = get(0);
            if (size == 1) {
                removeAll();
            } else {
                head = head.next;
                size--;
            }
            return item;
        }
        Node tmp = head;
        while (true) {
            if (index == 1) {
                T item = tmp.next.item;
                tmp.next = tmp.next.next;
                size--;
                return item;
            }
            tmp = tmp.next;
            index--;
        }
    }
}

