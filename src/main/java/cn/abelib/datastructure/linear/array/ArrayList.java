package cn.abelib.datastructure.linear.array;

import cn.abelib.util.commons.Constant;
import cn.abelib.util.exception.NoMoreElementException;

/**
 * @Author: abel-huang
 * @Date: 2017/1/11
 *  模仿JDK实现的动态数组
 */
public class ArrayList<T> extends AbstractArray<T> {
    /**
     *
     */
    public ArrayList(){
        this(Constant.DEFAULT_CAPACITY);
    }

    /**
     * @param capacity
     */
    public ArrayList(int capacity){
        data = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * 增加元素
     * @param item
     */
    public void add(T item){
        if(size == data.length){
            resize(2* data.length);
        }
        data[size++] = item;
    }

    public void add(int index, T item){
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if(size == data.length){
            resize(2* data.length);
        }
        for (int i = size; i > index; i--){
            data[i] = data[i-1];
        }
        data[index] = item;
        size++;
    }

    public T removeLast(){
        return remove(size - 1);
    }

    /**
     *  remove all element
     */
    public void removeAll(){
        size = 0;
    }

    /**
     *  contains
     * @param item
     * @return
     */
    public boolean contains(T item) {
        int index = find(item);
        return  index < size && index >= 0;
    }

    /**
     *  返回找到元素的索引，如果找不到则返回索引
     * @param item
     * @return
     */
    public int find(T item) {
        for (int i = 0; i< data.length; i++){
            if (data[i] == item){
                return i;
            }
        }
        return -1;
    }

    /**
     * remove certain element
     * @param item
     */
    public void removeElement(T item) {
        int index = find(item);
        remove(index);
    }

    /**
     * 通过 lazy-resize，防止复杂度震荡
     * @param index
     * @return
     */
    public T remove(int index){
        if (size == 0){
            throw new NoMoreElementException();
        }
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        T result = data[index];
        for (int i = index; i < size - 1; i++){
            data[i] = data[i + 1];
        }
        size--;
        if(size >0 && size == data.length/4){
            resize(data.length/2);
        }
        return result;
    }
}
