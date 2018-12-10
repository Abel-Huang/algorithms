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

    public boolean isEmpty(){
        return N==0;
    }

    public void push(T item){
       Node oldfirst=first;
        first=new Node();
        first.item=item;
        first.next=oldfirst;
        N++;
    }

    public T pop(){
        T item=first.item;
        first=first.next;
        N--;
        return item;
    }

    public T peek(){
        T item=first.item;
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
