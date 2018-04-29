package cn.abelib.sort;

import java.util.Arrays;

/**
 * Created by abel on 2018/4/30.
 *  基础排序的接口
 */
public interface SimpleSort{
    default void show(int [] a){
        Arrays.stream(a).forEach(System.out::println);
    }

    void sort(int [] a);
}
