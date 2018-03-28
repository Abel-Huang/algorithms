package cn.abelib.utils.sort;

/**
 * Created by abel-huang on 2017/7/12.
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
}
