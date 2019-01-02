package cn.abelib.algorithm.sort;

import java.util.Arrays;

/**
 *
 * @author abel
 * @date 2018/4/30
 *  Sort接口, 新增了一个默认方法
 */
public interface Sort {

    default void show(Comparable [] a){
        Arrays.stream(a).forEach(System.out::println);
    }

    void sort(Comparable [] a);
}
