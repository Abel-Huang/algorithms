package cn.abelib.datastructure.linear;

/**
 * @author abel
 * @date 2018/4/30
 * 集合接口
 */
public interface Collection<T> extends Iterable<T> {
    boolean isEmpty();

    int size();
}
