package cn.abelib.dataStructure.linear.list.array;


import cn.abelib.dataStructure.linear.list.List;
import cn.abelib.util.commons.Constant;

import java.util.Iterator;

/**
 * Created by abel-huang on 2017/1/11.
 *  模仿JDK实现的动态数组
 */
public class ArrayList<T> implements List<T> {
    private T[] a;
    private int N = 0;

    public ArrayList(){
        a = (T[]) new Object[Constant.DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity){
        a = (T[]) new Object[capacity];
    }

    /**
     *  数组改变容量
     * @param max
     */
    private void resize(int max){
        T[] temp=(T[])new Object[max];
        for(int i=0;i<a.length;i++){
            temp[i]=a[i];
        }
        a=temp;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public void add(T item){
        if(N==a.length){
            resize(2*a.length);
        }
        a[N++]=item;
    }

    public T get(int index){

        return null;
    }

    public T delTail(){
        T item=a[--N];
        a[N]=null;
        if(N>0&&N==a.length/4){
            resize(a.length/2);
        }
        return item;
    }

    public boolean find(T item) {
        return false;
    }

    public void remove(T item) {

    }

    public T delete(int index){
        return null;
    }

    public int size(){
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        private int i=N;
        @Override
        public boolean hasNext() {
            return i>0;
        }
        @Override
        public T next() {
            return a[--i];
        }
        public void remove(){}
    }
}
