package cn.abelib.algorithm.sort.counting;

/**
 * Created by abel on 2018/4/11.
 * 计数排序
 * 计数排序是基数排序和桶排序的基础
 * 时间复杂度为(N+K) K 是排序元素的范围 空间复杂度为 K
 * 这里以0-1000的数字排序作为应用范围
 */
public class SimpleCountingSort {
    private final int ITEM_SIZE = 1000;
    public void sort(int[] a){
        int[] map = new int[ITEM_SIZE + 1];
        for (int i = 0; i < a.length; i++){
            if (map[a[i]] == 0){
                map[a[i]] = 1;
            }else {
                map[a[i]]++;
            }
        }
        int index = 0;
        for (int i =0; i< map.length; i++){
            if (map[i] != 0){
                for (int j = 0; j< map[i]; j++){
                    a[index] = i;
                    index++;
                }
            }
        }
    }
}
