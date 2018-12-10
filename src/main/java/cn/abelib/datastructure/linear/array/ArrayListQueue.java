package cn.abelib.datastructure.linear.array;

import cn.abelib.datastructure.linear.Queue;

import java.util.Iterator;


/**
 * Created by abel-huang on 2016/12/25.
 */
public class ArrayListQueue<T> implements Queue<T> {
    private T[] a=(T[])new Object[1];
    private int N=0;
    public ArrayListQueue(){}

    private void resize(int max){
        T[] temp=(T[])new Object[max];
        for(int i=0;i<a.length;i++){
            temp[i]=a[i];
        }
        a=temp;
    }

    @Override
    public boolean isEmpty(){
        return N==0;
    }

    public void enqueue(T item){
        if(N==a.length){
            resize(2*a.length);
        }
        a[N++]=item;
    }

    public T dequeue(){
        T item=a[0];
        for(int i=0;i<N-1;i++){
            a[i]=a[i+1];
        }
        a[N-1]=null;
        --N;
        if(N>0&&N==a.length/4){
            resize(a.length/2);
        }
        return item;
    }

    @Override
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

        @Override
        public void remove(){}
    }
}
