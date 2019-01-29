package cn.abelib.datastructure.linear.set;

import org.junit.Before;
import org.junit.Test;

/**
 * @Author: abel.huang
 * @Date: 2019-01-09 23:01
 */
public class LinkedListSetTest {
    private Set<Integer> linkedListSet = new LinkedListSet<>();

    @Before
    public void init() {
        linkedListSet.add(1);
        linkedListSet.add(1);
        linkedListSet.add(2);
        linkedListSet.add(2);
        linkedListSet.add(3);
        linkedListSet.add(3);
    }

    @Test
    public void addTest() {
        System.out.println(linkedListSet.size());
        System.out.println(linkedListSet.isEmpty());
    }

    @Test
    public void containsTest() {
        System.out.println(linkedListSet.contains(1));
        System.out.println(linkedListSet.contains(2));
        System.out.println(linkedListSet.contains(4));
    }

    @Test
    public void remove() {
        linkedListSet.remove(1);
        System.out.println(linkedListSet.size());
        System.out.println(linkedListSet);
    }
}
