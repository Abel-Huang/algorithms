package cn.abelib.datastructure.linear.set;

import cn.abelib.datastructure.linear.list.LinkedList;

/**
 * @Author: abel.huang
 * @Date: 2019-01-09 22:57
 */
public class LinkedListSet<T> implements Set<T> {
    private LinkedList<T>  setList;

    public LinkedListSet() {
        setList = new LinkedList<>();
    }

    @Override
    public void add(T item) {
        if (setList.contains(item)) {
            return;
        }
        setList.add(item);
    }

    @Override
    public void remove(T item) {
        setList.removeElement(item);
    }

    @Override
    public boolean contains(T item) {
        return setList.contains(item);
    }

    @Override
    public int size() {
        return setList.size();
    }

    @Override
    public boolean isEmpty() {
        return setList.isEmpty();
    }

    @Override
    public String toString() {
        // todo
        return setList.toString();
    }
}
