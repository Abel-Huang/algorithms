package com.main.basic.collection;

import java.util.Iterator;

/**
 * Created by huangjianjin on 2016/12/25.
 */
public class Queue<Item> implements Iterable<Item>{
    private Item[] a=(Item[])new Object[1];
    private int N=0;
    public Queue(){}

    private void resize(int max){
        Item[] temp=(Item[])new Object[max];
        for(int i=0;i<a.length;i++){
            temp[i]=a[i];
        }
        a=temp;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public void enqueue(Item item){
        if(N==a.length){
            resize(2*a.length);
        }
        a[N++]=item;
    }

    public Item dequeue(){
        Item item=a[0];
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

    public int size(){
        return N;
    }

    public Iterator<Item> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Item> {
        private int i=N;
        @Override
        public boolean hasNext() {
            return i>0;
        }
        @Override
        public Item next() {
            return a[--i];
        }
        public void remove(){}
    }
}
