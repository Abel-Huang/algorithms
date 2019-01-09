package cn.abelib.datastructure.map;


/**
 * @author abel-huang
 * @date 2017/7/23
 */
public interface Map<K, V> {
    int size();

    boolean put(K key, V value);

    boolean contains(K key);

    V get(K key);

    void set(K key, V value);

    boolean isEmpty();

    V remove(K key);
}
