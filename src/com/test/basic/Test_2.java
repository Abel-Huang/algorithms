package com.test.basic;

import com.main.basic.util.StdIO;
import com.main.sort.InsertionSort;

/**
 * Created by huangjinajin on 2017/1/11.
 */
public class Test_2 {
    private Node first;
    private int N;
    private class Node{
        int item;
        Node next;
    }
    public static void main(String []args){
        InsertionSort i =new InsertionSort();
        StdIO.print(i.getClass().getSimpleName());
    }
}
