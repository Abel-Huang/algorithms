package cn.abelib.datastructure.map;

import cn.abelib.datastructure.linear.linked.LinkedList;

import java.util.NoSuchElementException;

/**
 * @Author: abel.huang
 * @Date: 2019-01-09 23:46
 */
public class LinkedListMap<K, V> implements Map<K, V> {
    private LinkedList<NodeEntry<K, V>> mapList;

    private class NodeEntry<K, V> {
        K key;
        V value;

        NodeEntry() {
            this(null, null);
        }

        NodeEntry(K key) {
            this(key, null);
        }


        NodeEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public LinkedListMap() {
        mapList = new LinkedList<>();
    }

    @Override
    public int size() {
        return mapList.size();
    }

    @Override
    public boolean put(K key, V value) {
        if (contains(key)) {
            return false;
        }
        int size = size();
        mapList.add(new NodeEntry<>(key, value));
        return size() - 1 == size;
    }

    @Override
    public boolean contains(K key) {
       return find(key) >= 0;
    }

    private int find(K key) {
        if (size() < 1) {
            return -1;
        }
        for (int i = 0; i < mapList.size(); i++) {
            if (mapList.get(i).getKey() == key) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        int index = find(key);
        if (index < 0) {
            throw new NoSuchElementException("Key does not exists");
        }
        return mapList.get(index).getValue();
    }

    @Override
    public void set(K key, V value) {
        int index = find(key);
        if (index < 0) {
            throw new NoSuchElementException("Key does not exists");
        }
        mapList.set(index, new NodeEntry<>(key, value));
    }

    @Override
    public boolean isEmpty() {
        return mapList.isEmpty();
    }

    @Override
    public V remove(K key) {
        int index = find(key);
        if (index < 0) {
            throw new NoSuchElementException("Key does not exists");
        }
        return mapList.remove(index).getValue();
    }
}
