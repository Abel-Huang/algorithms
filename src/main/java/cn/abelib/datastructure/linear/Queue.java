package cn.abelib.datastructure.linear;

/**
 * @author abel
 * @date 2018/4/30
 * 单向队列接口
 */
public interface Queue<T> extends Collection<T> {
    void enqueue(T item);

    T dequeue();

    T getFront();
}
