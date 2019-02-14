package cn.abelib.datastructure.map;


import cn.abelib.util.annotation.UnFinish;

/**
 * @author abel-huang
 * @date 2017/12/25
 * BinaryTreeMap
 * todo
 */
public class BinaryTreeMap<K extends Comparable<K>, V> implements Map<K, V>{
    private int size;
    private ComparableEntry<K, V> root;

    public BinaryTreeMap() {
        size = 0;
        root = null;
    }

    private class ComparableEntry<K extends Comparable<K>, V> implements Comparable<K> {
        private K key;
        private V value;
        private ComparableEntry<K, V> left;
        private ComparableEntry<K, V> right;

        private ComparableEntry(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }

        @Override
        public int compareTo(K k) {
            return key.compareTo(k);
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean put(K key, V value) {
        if (contains(key)) {
            return false;
        }
        root = put0(root, key, value);
        return true;
    }

    private ComparableEntry<K, V> put0(ComparableEntry<K, V> entry, K key, V value) {
        if (entry == null) {
            size ++;
            return new ComparableEntry<>(key, value);
        }
        if (entry.key.compareTo(key) > 0) {
            entry.left = put0(entry.left, key, value);
        } else if (entry.key.compareTo(key) < 0) {
            entry.right = put0(entry.right, key, value);
        }
        return entry;
    }

    @Override
    public boolean contains(K key) {
        return contains(root, key);
    }

    private boolean contains(ComparableEntry<K, V> entry, K key) {
        if (entry == null) {
            return false;
        }
        if (entry.key.compareTo(key) > 0) {
            return contains(entry.left, key);
        } else if (entry.key.compareTo(key) == 0) {
            return true;
        } else {
            return contains(entry.right, key);
        }
    }

    /**
     *  todo
     */
    @Override
    public V get(K key) {
        return null;
    }

    /**
     *  todo
     */
    @Override
    public void set(K key, V value) {

    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     *  todo
     */
    @UnFinish
    @Override
    public V remove(K key) {
        return null;
    }
}
