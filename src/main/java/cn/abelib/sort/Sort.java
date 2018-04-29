package cn.abelib.sort;

import java.util.Arrays;

/**
 * Created by abel on 2018/4/30.
 *  Sort接口, 新增了一个默认方法
 */
public interface Sort {

    default void show(Comparable [] a){
        Arrays.stream(a).forEach(System.out::println);
    }

    void sort(Comparable [] a);
}
