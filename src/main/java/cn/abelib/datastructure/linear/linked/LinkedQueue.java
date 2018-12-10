package cn.abelib.datastructure.linear.linked;

import cn.abelib.datastructure.linear.Queue;

import java.util.Iterator;

/**
 * Created by abel-huang on 2017/1/10.
 */
public class LinkedQueue<T> implements Queue<T> {
    private Node first;
    private Node last;
    private int N;
    private class Node{
        T item;
        Node next;
    }

    public LinkedQueue(){}

    public boolean isEmpty(){
        return N==0;
    }

    public void enqueue(T item){
        Node oldLast=last;
        last=new Node();
        last.item=item;
        last.next=null;
        if (isEmpty())
            first=last;
        else
            oldLast.next=last;
        N++;
    }

    public T dequeue(){
        T item=first.item;
        first=first.next;
        if (isEmpty())
            last=null;
        N--;
        return item;
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
