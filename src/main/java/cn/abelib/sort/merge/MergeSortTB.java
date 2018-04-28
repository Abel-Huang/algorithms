package cn.abelib.sort.merge;


import cn.abelib.sort.AbstractSort;

/**
 * Created by abel-huang on 2017/7/17.
 */
public class MergeSortTB extends AbstractSort {
    protected Comparable [] extra;
//    sort from top to bottom
    @Override
    public void sort(Comparable[] a) {
        extra=new Comparable[a.length];
        sort(a, 0, a.length-1);
    }
    private void sort(Comparable[] a, int low, int high) {
        if (low>=high)
            return;
        int mid=low+(high-low)/2;
        sort(a, low, mid);
        sort(a, mid+1, high);
        merge(a, low, mid, high);
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
