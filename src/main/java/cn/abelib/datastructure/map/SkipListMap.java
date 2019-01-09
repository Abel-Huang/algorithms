package cn.abelib.datastructure.map;


/**
 * @author abel
 * @date 2018/1/24
 */
public class SkipListMap<K, V> implements Map<K, V> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean put(K key, V value) {
        return false;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void set(K key, V value) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public V remove(K key) {
        return null;
    }
}
