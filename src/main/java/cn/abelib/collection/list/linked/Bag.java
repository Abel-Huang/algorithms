package cn.abelib.collection.list.linked;

import cn.abelib.collection.Collection;

import java.util.Iterator;

/**
 * Created by abel-huang on 2016/12/25.
 */
public class Bag<T> implements Collection<T> {
    private Node first;
    private int N;
    private class Node{
        T item;
        Node next;
    }

    public Bag(){}

    public boolean isEmpty(){
        return N==0;
    }

    public void add(T item){
        Node oldFirst=first;
        first=new Node();
        first.item=item;
        first.next=oldFirst;
        N++;
    }

    public int size(){
        return N;
    }

    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        private Node current=first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }
        @Override
        public T next() {
            T item=current.item;
            current=current.next;
            return item;
        }
        public void remove(){}
    }
}
