package cn.abelib.sort;


import java.util.Arrays;

/**
 * Created by abel-huang on 2017/7/12.
 * A array abstract class for sort
 */
public abstract class AbstractSort {
    public  abstract void sort(Comparable [] a);

    public  boolean less(Comparable f, Comparable b){
        return f.compareTo(b)<0;
    }

    public void exchange(Comparable [] a, int i, int j){
        Comparable tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }

    public void show(Comparable [] a){
        Arrays.stream(a).forEach(System.out::println);
    }

    public boolean isSorted(Comparable [] a){
        for(int i=1;i<a.length;i++){
            if (less(a[i],a[i-1]))
                return false;
        }
        return true;
    }
}
