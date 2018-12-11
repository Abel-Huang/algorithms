package cn.abelib.datastructure.linear.array;


import org.junit.Before;
import org.junit.Test;

/**
 * Created by abel-huang on 2017/7/22.
 * The unit string for ArrayList
 */

public class BaseArrayListTest {
    ArrayList<Integer> arrayList = new ArrayList<>();


    @Before
    public void init(){
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
    }

    @Test
    public void add(){
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println(arrayList.size());
        System.out.println(arrayList.capacity());
        arrayList.add(1, 4);
        System.out.println(arrayList.get(3));
        System.out.println(arrayList.size());
        System.out.println(arrayList.capacity());
    }

    @Test
    public void get(){
//        System.out.println(arrayList.get(0));
//        System.out.println(arrayList.get(1));
//        System.out.println(arrayList.get(2));
        arrayList.add(16);
        for (Integer i : arrayList){
            System.out.println(i);
        }
        System.out.println(arrayList.size());
    }
}
