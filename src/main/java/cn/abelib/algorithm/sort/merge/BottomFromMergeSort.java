package cn.abelib.algorithm.sort.merge;


import cn.abelib.algorithm.sort.AbstractSort;

/**
 * Created by abel-huang on 2017/7/19.
 *
 */
public class BottomFromMergeSort extends AbstractSort {
    protected Comparable [] extra;
    //    sort from top to bottom
    @Override
    //    sort from bottom to top
    public void sort(Comparable[] a){
        extra=new Comparable[a.length];
        for( int sz=1;sz<a.length;sz+=sz){
            for(int low=0; low<a.length-sz; low+=sz+sz){
                merge(a, low, low+sz-1,Math.min(low+sz+sz-1,a.length-1));
            }
        }
    }

    protected void merge(Comparable[] a, int low, int mid, int high){
        int i=low, j=mid+1;
        for(int k=low;k<=high;k++)
            extra[k]=a[k];
        for(int k=low;k<=high;k++)
//            left array is empty
            if(i>mid)
                a[k]=extra[j++];
//            right array is empty
            else if (j>high)
                a[k]=extra[i++];
//            select the smaller item between the first item of two array
            else if (less(extra[j], extra[i]))
                a[k]=extra[j++];
            else
                a[k]=extra[i++];
    }

}
