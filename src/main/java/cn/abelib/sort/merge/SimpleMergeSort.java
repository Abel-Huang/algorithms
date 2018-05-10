package cn.abelib.sort.merge;

/**
 * Created by abel-huang on 2017/7/11.
 * 时间复杂度为NlogN 其中递归sort()的复杂度为logN merge()的复杂度为N
 *  需要额外的空间进行排序
 */
public class SimpleMergeSort {
    private int[] temp;
    public void sort(int[] a){
        temp = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int left, int right){
        if (left >= right){
            return;
        }
        int mid = (right -left)/2 + left;
        sort(a, left, mid);
        sort(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    private void merge(int[] a, int left, int middle, int right){
        int i = left;
        int j = middle + 1;
        System.arraycopy(a, left, temp, left, right - left + 1);
        for (int k = 0; k <= right - left; k++){
            if (i > middle){
                a[left + k] = temp[j];
                j++;
            }
            else if (j > right){
                a[left + k] = temp[i];
                i++;
            }
            else if (temp[i] <= temp[j]){
                a[left + k] = temp[i];
                i++;
            }else {
                a[left + k] = temp[j];
                j++;
            }
        }
    }
}
