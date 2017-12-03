package cn.abelib.other;

/**
<<<<<<< HEAD
 * Created by abel-huang on 2016/12/12.
=======
 * Created by huangjianjin on 2016/12/12.
>>>>>>> 245eb44931ba0001767e05c615c1e630842b2ec3
 */
public class Other {
    // method of successive division for greatest common divisor
    public static int gcd(int p,int q){
        //Integer
        if(q==0)
            return q;
        int r=p%q;
        return gcd(q,r);
    }
    public static int binarySearch(int key, int[] a){
        int l0=0;
        int h1=a.length-1;
        while(l0<=h1){
            int mid=l0+(h1-l0)/2;
            if(key<a[mid])
                h1=mid-1;
            else if(key>a[mid])
                l0=mid+1;
            else
                return mid;
        }
        return -1;
    }
}
