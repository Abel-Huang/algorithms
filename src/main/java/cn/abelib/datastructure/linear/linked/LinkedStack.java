package cn.abelib.datastructure.linear.linked;


import cn.abelib.datastructure.linear.Stack;

import java.util.Iterator;

/**
 * Created by abel-huang on 2016/12/27.
 */
public class LinkedStack<T> implements Stack<T> {
    private Node first;
    private int N;

    private class Node{
        T item;
        Node next;
    }

    public LinkedStack(){}

    @Override
    public boolean isEmpty(){
        return N==0;
    }

    @Override
    public void push(T item){
       Node oldfirst=first;
        first=new Node();
        first.item=item;
        first.next=oldfirst;
        N++;
    }

    @Override
    public T pop(){
        T item=first.item;
        first=first.next;
        N--;
        return item;
    }

    @Override
    public T peek(){
        T item=first.item;
        return item;
    }

    @Override
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
        @Override
        public void remove(){}
    }
}
