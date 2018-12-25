package cn.abelib.datastructure.linear.array;

import cn.abelib.datastructure.linear.Stack;
import cn.abelib.util.commons.Constant;
import cn.abelib.util.exception.NoMoreElementException;

/**
 * @Author: abel-huang
 * @Date: 2016/12/25
 */
public class ArrayListStack<T> extends AbstractArray<T> implements Stack<T> {
    /**
     * empty construction
     */
    public ArrayListStack(){
        this(Constant.DEFAULT_CAPACITY);
    }

    /**
     *
     * @param capacity
     */
    public ArrayListStack(int capacity){
        data = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
    public void push(T item){
        if(size == data.length){
            resize(2* data.length);
        }
        data[size++]=item;
    }

    @Override
    public T pop(){
        if (size < 1) {
            throw new NoMoreElementException();
        }
        T item= data[--size];
        data[size]=null;
        if(size >0&& size == data.length/4){
            resize(data.length/2);
        }
        return item;
    }

    @Override
    public T peek(){
        if (size < 1) {
            throw new NoMoreElementException();
        }
        T item= data[size -1];
        return item;
    }
 }
