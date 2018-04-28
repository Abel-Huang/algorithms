package cn.abelib.sort.priority.heap;

/**
 * Created by abel-huang on 2017/7/30.
 */
public class MaxPriorityQueue <K extends Comparable<K>>{
    private K[] maxpq;
    private int N=0;

    public MaxPriorityQueue(int maxN){
        maxpq = (K[]) new Comparable[maxN+1];
    }

    public MaxPriorityQueue(){
        maxpq = (K[]) new Comparable[17];
    }

    private void resize(int max){
        K[] temp=(K[])new Comparable[max];
        for(int i=0;i<maxpq.length;i++){
            temp[i]=maxpq[i];
        }
        maxpq=temp;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void insert(K k){
        if (N == maxpq.length-1){
            resize(2 * maxpq.length);
        }
        maxpq[++N] = k;
        rise(N);
    }

    public K delMax(){
        K max = maxpq[1];
        exchange(1, N--);
        maxpq[N+1] = null;
        sink(1);
       if (N >0 && N == maxpq.length/4){
           resize(maxpq.length/2);
       }
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
