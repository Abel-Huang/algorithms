package cn.abelib.collection.list.linked;


import cn.abelib.collection.list.linked.LinkedList;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by abel-huang on 2016/12/25.
 */
public class LinkedListTest {
    LinkedList<Integer> linkedList;
    @Before
    public void init(){
        linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
    }

   @Test
    public void isEmptyTest(){
        System.out.println(linkedList.isEmpty());
   }

   @Test
    public void getTest(){
       System.out.println(linkedList.get(0));
       System.out.println(linkedList.get(1));
       System.out.println(linkedList.get(2));
       System.out.println(linkedList.get(3));
       System.out.println(linkedList.get(4));
   }

   @Test
    public void delTailTest(){
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
    public void findTest(){

    }


    @Test
    public void removeTest(){

    }

    @Test
    public void deleteTest(){

    }
}
