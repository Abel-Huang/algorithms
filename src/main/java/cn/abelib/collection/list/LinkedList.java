package cn.abelib.collection.list;

import java.util.Iterator;

/**
 * Created by abel-huang on 2017/1/11.
 * This is a linked list
 */
public class LinkedList<Item> implements Iterable<Item>{
    private Node first;
    private Node last;
    private int N;
    private class Node{
        Item item;
        Node next;
    }

    public LinkedList(){}

    public boolean isEmpty(){
        return N==0;
    }

    public void add(Item item){
        Node oldnow=last;
        last=new Node();
        last.item=item;
        last.next=null;
        if(N==0){
            first=last;
        }
        else{
            oldnow.next=last;
        }
        N++;
    }

    public Item get(int index){
        Node temp=first;
        while (index>1){
            temp=temp.next;
            index--;
        }
        return temp.item;
    }

    public Item delTail(){
        Item item=last.item;
        last=null;
        Node temp=first;
        while (temp!=null){
            if (temp.next.next==null){
                temp.next=temp.next.next;
                last=temp;
                N--;
                break;
            }
           temp=temp.next;
        }
        return item;
    }

    public boolean find(Item item) {
        boolean isFind=false;
        Node temp=first;
        while (temp!=null){
            if ((temp.item+"").equals(item+"")){
                isFind=true;
                break;
            }
            temp=temp.next;
        }
        return isFind;
    }

    public void remove(Item item) {
        if((last.item+"").equals(item+"")){
            delTail();
        }
        else if((first.item+"").equals(item+"")){
            Node temp=first;
            first=temp.next;
            temp=null;
            N--;
            if(N<2){
                last=first;
            }
        }
        else{
            Node temp=first;
            while (temp.next!=null){
                if ((temp.next.item+"").equals(item+"")){
                    temp.next=temp.next.next;
                    N--;
                }
                temp=temp.next;
            }
        }
    }

    public Item delete(int index){
        if(index==N){
            return delTail();
        }
        else if(index==1){
            Node temp=first;
            Item item=last.item;
            first=temp.next;
            temp=null;
            N--;
            if(N<2){
                last=first;
            }
            return item;
        }
        else if(index<N&&index>1){
            Node temp=first;
            while (index>2){
                temp=temp.next;
                index--;
            }
            Item item=temp.next.item;
            temp.next=temp.next.next;
            //first=temp;
            N--;
            return item;
        }
        else{
            return null;
        }
    }

    public int size(){
        return N;
    }

    public Iterator<Item> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Item> {
        private Node current=first;
        private int i=N;
        @Override
        public boolean hasNext() {
            return i>0;
        }
        @Override
        public Item next() {
            Item item=current.item;
            current=current.next;
            i--;
            return item;
        }
        public void remove(){}
    }
}

