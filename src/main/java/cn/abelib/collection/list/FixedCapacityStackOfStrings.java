package cn.abelib.collection.list;

/**
<<<<<<< HEAD
 * Created by abel-huang on 2016/12/25.
 * This is a fixed capacity stack witch could only store src.main.string.
 */
public class FixedCapacityStackOfStrings {
    private String[] a;
    private int N;
    private int initCap;
    public FixedCapacityStackOfStrings(int cap){
        a=new String[cap];
        initCap=cap;

    }

    public void push(String item){
        a[N++]=item;
    }

    //pra 1.3.1
    public boolean isFull(){
        return N==initCap;
    }

    public String pop(){
        return a[--N];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }
}
