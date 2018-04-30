package cn.abelib.sort.heap;


/**
 * Created by abel-huang on 2017/7/30.
 */
public class MinPriorityQueue  <K extends Comparable<K>>{
    private K[] minpq;
    private int N=0;

    public MinPriorityQueue(int maxN){
        minpq = (K[]) new Comparable[maxN+1];
    }

    public MinPriorityQueue(){
        minpq = (K[]) new Comparable[17];
    }

    private void resize(int max){
        K[] temp=(K[])new Comparable[max];
        for(int i=0;i<minpq.length;i++){
            temp[i]=minpq[i];
        }
        minpq=temp;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void insert(K k){
        if (N == minpq.length-1){
            resize(2 * minpq.length);
        }
        minpq[++N] = k;
        rise(N);
    }

    public K delMin(){
        K min = minpq[1];
        exchange(1, N--);
        minpq[N+1] = null;
        sink(1);
        if (N >0 && N == minpq.length/4){
            resize(minpq.length/2);
        }
        return min;
    }

    private boolean less(int i,int j){
        return minpq[i].compareTo(minpq[j])<0;
    }

    private void exchange(int i, int j){
        K tmp = minpq[i];
        minpq[i] = minpq[j];
        minpq[j] = tmp;
    }

    private void rise(int k){
        while(k > 1  && !less(k/2, k)){
            exchange(k/2, k);
            k /= 2;
        }
    }

    private void sink(int k){
        while(2*k < N){
            int j = 2*k;
            if(j <N && !less(j, j+1)){
                j++;
            }
            if (less(k, j))
                break;
            exchange(k, j);
            k = j;
        }
    }
}
