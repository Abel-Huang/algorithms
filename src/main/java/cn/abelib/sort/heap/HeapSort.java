package cn.abelib.sort.heap;


import cn.abelib.sort.AbstractSort;

/**
 * Created by abel-huang on 2017/7/31.
 */
public class HeapSort extends AbstractSort {
    public void sort(Comparable [] a){
        int N = a.length-1;
        for (int k =N/2; k>=0; k--){
            sink(a, k, N);
        }
        while (N > 0){
            exchange(a, 0, N--);
            sink(a, 0, N);
        }
    }

    private void sink(Comparable [] a, int k, int N){
        while(2*k+1 <= N){
            int j = 2*k + 1;
            if(j < N  && less(a[j], a[j+1])){
                j++;
            }
            if (!less(a[k], a[j]))
                break;
            exchange(a, k, j);
            k = j;
        }
    }
}
