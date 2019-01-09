package cn.abelib.datastructure.linear;

/**
 * @author abel-huang
 * @date 2017/1/19
 */
public interface Set<T> {
    void add(T item);

    void remove(T item);

    boolean contains(T item);

    int size();

    boolean isEmpty();
}
