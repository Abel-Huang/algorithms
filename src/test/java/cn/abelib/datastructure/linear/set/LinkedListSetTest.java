package cn.abelib.datastructure.linear.set;

import cn.abelib.datastructure.linear.Set;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: abel.huang
 * @Date: 2019-01-09 23:01
 */
public class LinkedListSetTest {
    private Set<Integer> treeSet = new LinkedListSet<>();

    @Before
    public void init() {
        System.out.println(treeSet.size());
        System.out.println(treeSet.isEmpty());
        treeSet.add(1);
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(3);
    }

    @Test
    public void addTest() {
        System.out.println(treeSet.size());
        System.out.println(treeSet.isEmpty());
    }
}
