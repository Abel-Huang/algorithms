package cn.abelib.datastructure.linear;


/**
 * Created by abel on 2018/4/30.
 *  集合接口
 */
public interface Collection<T> extends Iterable<T>{
    boolean isEmpty();

    int size();
}
