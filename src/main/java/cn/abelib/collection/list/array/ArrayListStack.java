package cn.abelib.collection.list.array;

import cn.abelib.collection.list.Stack;

import java.util.Iterator;

/**
 * Created by abel-huang on 2016/12/25.
 */
public class ArrayListStack<T> implements Stack<T> {
    private T[] a=(T[])new Object[1];
    private int N=0;
    public ArrayListStack(){}

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

    public void push(T item){
        if(N==a.length){
            resize(2*a.length);
        }
        a[N++]=item;
    }

    public T pop(){
        T item=a[--N];
        a[N]=null;
        if(N>0&&N==a.length/4){
            resize(a.length/2);
        }
        return item;
    }

    public T peek(){
        T item=a[N-1];
        return item;
    }

    public int size(){
        return N;
    }


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
