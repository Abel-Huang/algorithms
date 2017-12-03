package cn.abelib.sort;

/**
 * Created by abel-huang on 2017/7/13.
 * Shell sort, based on Insert sort
 */
public class ShellSort extends BasicSort {
    @Override
    public void sort(Comparable[] a) {
        int h=1;
        int len=a.length;
        while(h<len/3){
            h=3*h+1;
        }
        while(h>=1){
            for(int i=h;i<len;i++){
                for(int j=i; j>=h&&less(a[j], a[j-h]);j-=h){
                    exchange(a, j, j-h);
                }
            }
            h/=3;
        }
    }
}
