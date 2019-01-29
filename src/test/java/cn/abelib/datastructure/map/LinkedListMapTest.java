package cn.abelib.datastructure.map;

import org.junit.Before;
import org.junit.Test;

/**
 * @Author: abel.huang
 * @Date: 2019-01-20 01:05
 */
public class LinkedListMapTest {
    private Map<Integer, String> linkedListMap = new LinkedListMap<>();

    @Before
    public void init() {
        linkedListMap.put(1, "Hello");
        linkedListMap.put(2, "World");
        linkedListMap.put(3, "LinkedList");
        linkedListMap.put(4, "Map");
        System.out.println(linkedListMap.isEmpty());
        System.out.println(linkedListMap.size());
    }

    @Test
    public void getTest() {
        System.out.println(linkedListMap.get(1));
        System.out.println(linkedListMap.get(2));
        System.out.println(linkedListMap.get(4));
    }

    @Test
    public void setTest() {
        linkedListMap.set(1, "Apple");
        System.out.println(linkedListMap.get(1));
        linkedListMap.set(2, "Bear");
        System.out.println(linkedListMap.get(2));
        linkedListMap.set(4, "Canada");
        System.out.println(linkedListMap.get(4));
        System.out.println(linkedListMap.size());
    }

    @Test
    public void removeTest() {
        linkedListMap.remove(1);
        //System.out.println(linkedListMap.getTop(1));
        System.out.println(linkedListMap.size());
    }
}
