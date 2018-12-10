package cn.abelib.algorithm.sort.quick;


/**
 * Created by abel-huang on 2017/7/12.
 *  简单的快速排序
 */
public  class SimpleQuickSort {
    public void sort(int [] a, int left, int right){
        if (left >= right){
             return;
        }
        int j = partition(a, left, right);
        sort(a, left, j-1);
        sort(a, j+1 , right);
    }

    private int partition(int[] a, int left, int right){
        int part = a[left];
        while (left < right){
            while (part <= a[right] && left < right){
                right--;
            }
            a[left] = a[right];
            while (part >= a[left] && left < right){
                left++;
            }
            a[right] = a[left];
        }
        a[left] = part;
        return left;
    }
}
