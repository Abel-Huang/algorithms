package com.abel.sort;

/**
 * Created by huangjinajin on 2017/7/12.
 * A basic abstract class for sort
 */
public abstract class BasicSort {
    public  abstract void sort(Comparable [] a);

    public  boolean less(Comparable f, Comparable b){
        return f.compareTo(b)<0;
    }

    protected void exchange(Comparable [] a, int i, int j){
        Comparable tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }

    protected void show(Comparable [] a){
        for (Comparable c:a){
            System.out.print(c + " ");
        }
        System.out.println();
    }

    protected boolean isSorted(Comparable [] a){
        for(int i=1;i<a.length;i++){
            if (less(a[i],a[i-1]))
                return false;
        }
        return true;
    }
}
