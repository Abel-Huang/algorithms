package cn.abelib.utils.collection.list;

import java.util.Iterator;

/**
 * Created by abel-huang on 2017/1/10.
 */
public class LinkedQueue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;
    private class Node{
        Item item;
        Node next;
    }

    public LinkedQueue(){}

    public boolean isEmpty(){
        return N==0;
    }

    public void enqueue(Item item){
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

    public Item dequeue(){
        Item item=first.item;
        first=first.next;
        if (isEmpty())
            last=null;
        N--;
        return item;
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
