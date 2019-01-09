package cn.abelib.algorithm.search;

/**
 * @author abel
 * @date 2016/12/12
 */
public class BinarySearch {
    public int binarySearch(int key, int[] a) {
        int l0 = 0;
        int h1 = a.length - 1;
        while (l0 <= h1) {
            int mid = l0 + (h1 - l0) / 2;
            if (key < a[mid]) {
                h1 = mid - 1;
            } else if (key > a[mid]) {
                l0 = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
