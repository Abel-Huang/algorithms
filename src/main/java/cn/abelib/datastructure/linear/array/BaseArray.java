package cn.abelib.datastructure.linear.array;
import cn.abelib.datastructure.linear.Collection;

/**
 * @Author: abel-huang
 * @Date: 2018-12-11 22:54
 */

public abstract class BaseArray<T> implements Collection<T> {
    T[] data;
    int size;

    @Override
    public boolean isEmpty(){
        return size ==0;
    }

    /**
     *  resize
     * @param max
     */
    void resize(int max){
        T[] temp = (T[])new Object[max];
        for(int i = 0; i < data.length; i++){
            temp[i] = data[i];
        }
        data = temp;
    }

    public T get(int index){
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    public void set(int index, T item){
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        data[index] = item;
    }

    public int capacity(){
        return data.length;
    }

    @Override
    public int size(){
        return size;
    }
}
