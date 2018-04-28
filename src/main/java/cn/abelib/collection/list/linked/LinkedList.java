package cn.abelib.collection.list.linked;

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
        Node oldNow=last;
        last=new Node();
        last.item=item;
        last.next=null;
        if(N==0){
            first=last;
        }
        else{
            oldNow.next=last;
        }
        N++;
    }

    public Item get(int index){
        if (index < 0 || index >= N){
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        Node temp=first;
        while (index>0){
            temp=temp.next;
            index--;
        }
        return temp.item;
    }

    /**
     *  删除尾部元素
     * @return
     */
    public Item delTail(){
        if (N < 1){
            throw  new NullPointerException("No more Item in this list");
        }
        if (N == 1){
            Item result = first.item;
            first = null;
            last = null;
            N = 0;
            return result;
        }
        Item item=last.item;
        Node temp=first;
        while (temp.next!=last){
           temp=temp.next;
        }
        last = temp;
        temp.next = null;
        N--;
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

