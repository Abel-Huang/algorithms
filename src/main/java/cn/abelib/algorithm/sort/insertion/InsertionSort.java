package cn.abelib.algorithm.sort.insertion;

import cn.abelib.algorithm.sort.AbstractSort;

/**
 * Created by abel-huang on 2017/7/12.
 * Insert sort
 */
public class InsertionSort extends AbstractSort {
    @Override
    public void sort(Comparable[] a) {
        for (int i=1;i<a.length;i++){
            for(int j=i;j>0&&less(a[j],a[j-1]);j--){
                exchange(a, j, j - 1);
            }
        }
    }

    public void sort(Comparable[] a, int low, int high) {
        for (int i=low+1;i<=high;i++){
            for(int j=i;j>0&&less(a[j],a[j-1]);j--){
                exchange(a, j,j-1);
            }
        }
    }
}
