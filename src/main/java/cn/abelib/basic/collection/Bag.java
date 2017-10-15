package cn.abelib.basic.collection;

import java.util.Iterator;

/**
 * Created by huangjianjin on 2016/12/25.
 */
public class Bag<Item> implements Iterable<Item>{
    private Node first;
    private int N;
    private class Node{
        Item item;
        Node next;
    }

    public Bag(){}

    public boolean isEmpty(){
        return N==0;
    }

    public void add(Item item){
        Node oldfirst=first;
        first=new Node();
        first.item=item;
        first.next=oldfirst;
        N++;
    }

    public int size(){
        return N;
    }

    public Iterator<Item> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Item> {
        private Node current=first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }
        @Override
        public Item next() {
            Item item=current.item;
            current=current.next;
            return item;
        }
        public void remove(){}
    }
}
