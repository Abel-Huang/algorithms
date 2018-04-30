package cn.abelib.collection.list.linked;

import cn.abelib.collection.list.List;

import java.util.Iterator;

/**
 * Created by abel-huang on 2016/12/25.
 *  跳跃链表
 *  主要是参考Redis实现的SkipList
 */

public class SkipList<T> implements List<T>{
    @Override
    public void add(T item) {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T delTail() {
        return null;
    }

    @Override
    public boolean find(T item) {
        return false;
    }

    @Override
    public void remove(T item) {

    }

    @Override
    public T delete(int index) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
