package cn.abelib.sort;

/**
<<<<<<< HEAD
 * Created by abel-huang on 2017/7/12.
=======
 * Created by huangjinajin on 2017/7/12.
>>>>>>> 245eb44931ba0001767e05c615c1e630842b2ec3
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
