package cn.abelib.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: abel.huang
 * @Date: 2020-10-12 01:57
 */
public class CollectionUtils {

    private CollectionUtils(){}

    public static <T extends Object> List<? super T> subList(List<T> list, int fromIndex, int toIndex) {
        if (toIndex <= fromIndex) {
            throw new IndexOutOfBoundsException();
        }
        int len = toIndex - fromIndex;
        List<T> subList = new ArrayList<>(len);
        for (int i = fromIndex; i < toIndex; i ++) {
            subList.add(list.get(i));
        }
        return subList;
    }
}
