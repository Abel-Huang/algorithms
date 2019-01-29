package cn.abelib.datastructure.linear.list;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by abel-huang on 2017/7/22.
 * The unit string for ArrayList
 */

public class ArrayListTest {
    ArrayList<Integer> arrayList = new ArrayList<>();


    @Before
    public void init() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
    }

    @Test
    public void add() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println(arrayList.size());
        System.out.println(arrayList.capacity());
        arrayList.add(1, 4);
        System.out.println(arrayList.get(3));
        System.out.println(arrayList.size());
        System.out.println(arrayList.capacity());
        System.out.println(arrayList);
    }

    @Test
    public void get() {
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get(2));
        arrayList.add(16);
        for (Integer i : arrayList) {
            System.out.println(i);
        }
        System.out.println(arrayList);
    }

    @Test
    public void findAndContains() {
        System.out.println(arrayList.find(0));
        System.out.println(arrayList.find(2));
        System.out.println(arrayList.contains(0));
        System.out.println(arrayList.contains(2));
    }

    @Test
    public void remove() {
        System.out.println(arrayList);
//        arrayList.remove(0);
//        System.out.println(arrayList);
//        arrayList.removeLast();
//        System.out.println(arrayList);
//        arrayList.removeElement(2);
//        System.out.println(arrayList);
//        arrayList.removeElement(2);
//        System.out.println(arrayList);
        arrayList.removeAll();
        System.out.println(arrayList);
    }
}
