package cn.abelib.datastructure.linear.linked;


import cn.abelib.datastructure.linear.Stack;

import java.util.Iterator;

/**
 *
 * @author abel-huang
 * @date 2016/12/27
 */
public class LinkedStack<T>  implements Stack<T> {
    private Node head;
    private int size;

    private class Node{
        T item;
        Node next;
    }

    public LinkedStack(){}

    @Override
    public boolean isEmpty(){
        return size ==0;
    }

    @Override
    public void push(T item){
       Node oldHead= head;
        head =new Node();
        head.item=item;
        head.next=oldHead;
        size++;
    }

    @Override
    public T pop(){
        T item= head.item;
        head = head.next;
        size--;
        return item;
    }

    @Override
    public T peek(){
        return head.item;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        private Node current = head;
        private int i = size;
        @Override
        public boolean hasNext() {
            return i > 0;
        }
        @Override
        public T next() {
            T item=current.item;
            current=current.next;
            i--;
            return item;
        }
        @Override
        public void remove(){}
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(this.getClass().getSimpleName() + ": size=%d, content=", size));
        sb.append("[");
       Itr itr = new Itr();
        while (itr.hasNext()){
            sb.append(itr.next());
            if (itr.hasNext()){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
