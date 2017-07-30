package com.main.sort.priority.heap;


import com.main.basic.util.StdIO;

/**
 * Created by huangjinajin on 2017/7/30.
 */
public class MaxPriorityQueue <K extends Comparable<K>>{
    private K[] maxpq;
    private int N=0;

    public MaxPriorityQueue(int maxN){
        maxpq = (K[]) new Comparable[maxN+1];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void insert(K k){
        maxpq[++N] = k;
        rise(N);
    }

    public K delMax(){
        K max = maxpq[1];
        exchange(1, N--);
        maxpq[N+1] = null;
        sink(1);
        return max;
    }

    private boolean less(int i,int j){
        return maxpq[i].compareTo(maxpq[j])<0;
    }

    private void exchange(int i, int j){
        K tmp = maxpq[i];
        maxpq[i] = maxpq[j];
        maxpq[j] = tmp;
    }

    private void rise(int k){
        while(k > 1  && less(k/2, k)){
            exchange(k/2, k);
            k /= 2;
        }
    }

    private void sink(int k){
        while(2*k < N){
            int j = 2*k;
            if(j <N && less(j, j+1)){
                j++;
            }
            if (!less(k, j))
                break;
            exchange(k, j);
            k = j;
        }
    }
}
