package cn.abelib.datastructure.linear.set;

import cn.abelib.datastructure.linear.Set;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: abel.huang
 * @Date: 2019-01-09 22:45
 */
public class BinaryTreeSetTest {
    private Set<Integer> treeSet = new BinaryTreeSet<>();

    @Before
    public void init() {
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

    @Test
    public void containsTest() {
        System.out.println(treeSet.contains(1));
        System.out.println(treeSet.contains(2));
        System.out.println(treeSet.contains(4));
    }

    @Test
    public void remove() {
        treeSet.remove(1);
        System.out.println(treeSet.size());
        System.out.println(treeSet);
    }
}
