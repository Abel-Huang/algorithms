package cn.abelib.sort.priority;

/**
 * Created by abel-huang on 2017/7/20.
 */
public abstract class PriorityQueue<K extends Comparable<K>> {
    public K[] pq;
    public int N = 0;

    public PriorityQueue(int size){
        pq =  (K[]) new Comparable[size+1];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void insert(K k){
        pq[++N] = k;
        rise(N);
    }

    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j])<0;
    }

    private void exchange(int i, int j){
        K tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    protected abstract void rise(int k);

    protected abstract void sink(int k);

}
