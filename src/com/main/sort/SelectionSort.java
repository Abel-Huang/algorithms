package com.main.sort;

/**
 * Created by huangjinajin on 2017/7/12.
 * Selection sort
 */
public class SelectionSort extends BasicSort {
    @Override
    public  void sort(Comparable [] a){
        for(int i=0; i<a.length;i++){
            int index=i;
            for(int j=i+1;j<a.length;j++){
                if(less(a[j], a[index])){
                    index=j;
                }
            }
            exchange(a,index, i);
        }
    }
    public static void main(String args[]){
//        Integer[] a={2,3,4,5,6,1,10,9,8,12,2,1};
//        SelectionSort selection=new SelectionSort();
//        selection.sort(a);
//        if(selection.isSorted(a))
//            selection.show(a);
        String[] a={"as","bc","de","zz","jk","hk","hk","hj"};
        InsertionSort insertion=new InsertionSort();
        insertion.sort(a);
        System.out.print(a.length);
//        if(insertion.isSorted(a))
        insertion.show(a);
    }
}
