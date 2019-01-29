package cn.abelib.datastructure.linear.list;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by abel-huang on 2016/12/25.
 */
public class LinkedListTest {
    LinkedList<Integer> linkedList;

    @Before
    public void init() {
        linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
    }

    @Test
    public void isEmptyTest() {
        System.out.println(linkedList.isEmpty());
    }

    @Test
    public void reverseTest() {
        System.out.println(linkedList);
    }

    @Test
    public void getTest() {
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(3));
        System.out.println(linkedList.get(4));
    }

    @Test
    public void addTest() {
        linkedList.add(0, 0);
        linkedList.add(1, 1);
        linkedList.add(2, 2);
        linkedList.add(linkedList.size(), linkedList.size());
        System.out.println(linkedList);
    }

    @Test
    public void findTest() {
        System.out.println(linkedList.find(0));
        System.out.println(linkedList.find(1));
        System.out.println(linkedList.find(2));
    }

    @Test
    public void containsTest() {
        System.out.println(linkedList.contains(0));
        System.out.println(linkedList.contains(1));
        System.out.println(linkedList.contains(2));
    }

    @Test
    public void removeAllTest() {
        linkedList.removeAll();
        System.out.println(linkedList);
    }

    @Test
    public void removeTest() {
        System.out.println(linkedList);
        System.out.println(linkedList.remove(0));
        System.out.println(linkedList);
        System.out.println(linkedList.remove(1));
        System.out.println(linkedList);
        System.out.println(linkedList.remove(1));
        System.out.println(linkedList);
        System.out.println(linkedList.remove(0));
        System.out.println(linkedList);
        System.out.println(linkedList.remove(0));
        System.out.println(linkedList);
    }

    @Test
    public void delTailTest() {
        //System.out.println(linkedList.size());
        System.out.println(linkedList.delTail());
        //System.out.println(linkedList.size());
        System.out.println(linkedList.delTail());
        //System.out.println(linkedList.size());
        System.out.println(linkedList.delTail());
        System.out.println(linkedList.delTail());
        System.out.println(linkedList.delTail());
        System.out.println(linkedList.delTail());
    }

    @Test
    public void traverseTest() {
        linkedList.forEach(System.out::println);
    }
}
