package cn.abelib.datastructure.linear.stack;

import cn.abelib.datastructure.linear.Collection;

/**
 * @Author: abel-huang
 * @Date: 2018/4/30
 * 栈接口
 */
public interface Stack<T> extends Collection<T> {
    void push(T item);

    T pop();

    T peek();
}
