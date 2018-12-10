package cn.abelib.dataStructure.linear.list;

import cn.abelib.dataStructure.linear.Collection;


/**
 * Created by abel on 2018/4/30.
 *  List接口
 */
public interface List<T> extends Collection<T>{

    void add(T item);

    T get(int index);

    T delTail();

    boolean find(T item);

    void remove(T item);

    T delete(int index);
}
