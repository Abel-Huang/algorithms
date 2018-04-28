package cn.abelib.collection.list.array;


import cn.abelib.collection.list.linked.LinkedList;
import cn.abelib.commons.Constant;

import java.util.Iterator;

/**
 * Created by abel-huang on 2017/1/11.
 *  模仿JDK实现的动态数组
 */
public class ArrayList<Item> implements Iterable<Item> {
    private Item[] a;
    private int N = 0;

    public ArrayList(){
        a = (Item[]) new Object[Constant.DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity){
        a = (Item[]) new Object[capacity];
    }

    /**
     *  数组改变容量
     * @param max
     */
    private void resize(int max){
        Item[] temp=(Item[])new Object[max];
        for(int i=0;i<a.length;i++){
            temp[i]=a[i];
        }
        a=temp;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public void add(Item item){
        if(N==a.length){
            resize(2*a.length);
        }
        a[N++]=item;
    }

    public Item get(int index){

        return null;
    }

    public Item delTail(){
        Item item=a[--N];
        a[N]=null;
        if(N>0&&N==a.length/4){
            resize(a.length/2);
        }
        return item;
    }

    public boolean find(Item item) {
        return false;
    }

    public void remove(Item item) {

    }

    public Item delete(int index){
        return null;
    }

    public int size(){
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Item> {
        private int i=N;
        @Override
        public boolean hasNext() {
            return i>0;
        }
        @Override
        public Item next() {
            return a[--i];
        }
        public void remove(){}
    }
}
