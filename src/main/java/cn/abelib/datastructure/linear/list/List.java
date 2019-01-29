package cn.abelib.datastructure.linear.list;


import cn.abelib.datastructure.linear.Collection;

/**
 * @author abel
 * @date 2018/4/30
 * List接口
 */
public interface List<T> extends Collection<T> {

    void add(T item);

    T get(int index);

    T delTail();

    boolean find(T item);

    void remove(T item);

    T delete(int index);
}
