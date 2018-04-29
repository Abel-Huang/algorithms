package cn.abelib.collection.list.linked;

import org.junit.Test;


import java.util.LinkedList;

/**
 * Created by ${abel-huang} on 18/3/2.
 */
public class DListTest {
    @Test
    public void test(){
        LinkedList<String> list = new LinkedList<>();
        list.add("");
    }

    @Test
    public void init(){
        DLinkedList<String> list = new DLinkedList<>();
        list.add("hello");
        System.err.println(list.size());
        System.err.println(list.get(0));
        System.err.println(list.head());
        System.err.println(list.tail());
        list.add("world");
        System.err.println(list.size());
        System.err.println(list.get(1));
        System.err.println(list.head());
        System.err.println(list.tail());
        list.add("abel");
        System.err.println(list.size());
        System.err.println(list.get(2));
        System.err.println(list.head());
        System.err.println(list.tail());
        list.add("huang");
        System.err.println(list.size());
        System.err.println(list.get(0));
        System.err.println(list.get(1));
        System.err.println(list.get(2));
        System.err.println(list.get(3));
        System.err.println(list.head());
        System.err.println(list.tail());
    }

    @Test
    public void update(){
        DLinkedList<String> list = new DLinkedList<>();
        list.add("hello");
    }

    @Test
    public void index(){
        DLinkedList<Integer> list = new DLinkedList<>();
        System.err.println(list.index(1));
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.err.println(list.index(2));
        System.err.println(list.index(5));
    }

    @Test
    public void add() {
        DLinkedList<Integer> list = new DLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        DLinkedList<Integer> linkedList = new DLinkedList<>();
        linkedList.add(list);
        System.err.println(linkedList.next(0));
        System.err.println(linkedList.prev(1));
        System.err.println(linkedList.get(2));
        System.err.println(linkedList.get(3));
        System.err.println(linkedList.head());
        System.err.println(linkedList.tail());


    }

    @Test
    public void insert() {
        DLinkedList<Integer> list = new DLinkedList<>();
        list.add(1);
        list.add(2);

        list.insert(2, -1);
        list.insert(2, 3);
        list.insert(3, 3);
        list.insert(3, 4);

        for (int i = 0; i<list.size(); i++)
            System.err.println(list.get(i));

    }

    @Test
    public void tail() {
        DLinkedList<Integer> list = new DLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.err.println(list.head());
        System.err.println(list.tail());

    }

    @Test
    public void push() {
        DLinkedList<Integer> list = new DLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.lPush(0);
        list.lPush(-1);
        list.rPush(4);
        list.rPush(5);

        for (int i = 0; i<list.size(); i++)
            System.err.println(list.get(i));

    }


    @Test
    public void remove() {
        DLinkedList<Integer> list = new DLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.err.println(list.remove(0));
        System.err.println(list.remove(0));
//        list.remove(0);
//        for (int i = 0; i<list.len(); i++)
//            System.err.println(list.get(i));
//        list.remove(0);
//        list.remove(0);
//        System.err.println();
//        for (int i = 0; i<list.len(); i++)
//            System.err.println(list.get(i));
//        list.remove(0);

        for (int i = 0; i<list.size(); i++)
            System.err.println(list.get(i));

    }

    @Test
    public void pop() {
        DLinkedList<Integer> list = new DLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.err.println(list.lpop());
        System.err.println(list.rpop());

        System.err.println(list.size());

        for (int i = 0; i<list.size(); i++)
            System.err.println(list.get(i));

    }


    @Test
    public void removeAll() {
        DLinkedList<Integer> list = new DLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        for (int i = 0; i<list.size(); i++)
            System.err.println(list.get(i));
        list.removeAll();

        System.err.println(list.size());
        for (int i = 0; i<list.size(); i++)
            System.err.println(list.get(i));
    }
}
