package cn.abelib.utils.collection;


import java.util.Iterator;

/**
 * Created by abel-huang on 2016/12/27.
 */
public class LinkedStack<Item> implements Iterable<Item>{
    private Node first;
    private int N;
    private class Node{
        Item item;
        Node next;
    }

    public LinkedStack(){}

    public boolean isEmpty(){
        return N==0;
    }

    public void push(Item item){
       Node oldfirst=first;
        first=new Node();
        first.item=item;
        first.next=oldfirst;
        N++;
    }

    public Item pop(){
        Item item=first.item;
        first=first.next;
        N--;
        return item;
    }

    public Item peek(){
        Item item=first.item;
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
