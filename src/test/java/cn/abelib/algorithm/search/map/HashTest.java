package cn.abelib.algorithm.search.map;

import cn.abelib.datastructure.map.HashMap;
import cn.abelib.util.commons.MurmurHash2;
import org.junit.Test;

import java.util.List;

/**
 * Created by ${abel-huang} on 18/3/8.
 */
public class HashTest {
    @Test
    public void testHash(){
        String str1 = "bre2brt2gwegw";
        String str2 = "vnwqfj3m210fk3";
        long hash1 = MurmurHash2.hash(str1);
        long hash2 = MurmurHash2.hash(str1);
        long hash3 = MurmurHash2.hash(str2);
        long hash4 = MurmurHash2.hash(str2);

        long hash5 = str1.hashCode();
        long hash6 = str1.hashCode();
        long hash7 = str2.hashCode();
        long hash8 = str2.hashCode();

        System.err.println(hash1);
        System.err.println((hash1+"").length());
        System.err.println(hash2);

        System.err.println(hash3);
        System.err.println(hash4);

        System.err.println();

        System.err.println(hash5);
        System.err.println(hash6);

        System.err.println(hash7);
        System.err.println(hash8);

    }

    @Test
    public void minInt() {
        int min = Integer.MIN_VALUE;
        System.err.println(min);
        System.err.println(Math.abs(min));
    }

    @Test
    public void init() {
        HashMap<String, String> hashMap = new HashMap<>();
        System.err.println(hashMap.capacity());
        System.err.println(Math.abs(hashMap.size()));
    }

    @Test
    public void putTest(){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 2);
        hashMap.put(2, 3);
        hashMap.put(3, 4);
    }


    private int hash(Integer key){
        long code = MurmurHash2.hash(key.toString());
        return (int) code;
    }

    /**
     *  cal index in the ht
     * @param key
     * @return
     */
    private int index(Integer key){
        return hash(key)&15;
    }

    @Test
    public void testIndex(){
        int hash = hash(1);
        int index = index(1);
        System.err.println(hash);
        System.err.println(index);
    }

    @Test
    public void testGet() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 2);
        hashMap.put(1, 3);
        hashMap.put(1, 4);
        System.err.println("size now " + hashMap.size());
        Integer integer1 = hashMap.get(1);
        Integer integer2 = hashMap.get(1);
        Integer integer3 = hashMap.get(1);
        System.err.println("get 1 " + integer1);
        System.err.println("get 1 " + integer2);
        System.err.println("get 1 " + integer3);
        hashMap.put(1, 5);
        Integer integer4 = hashMap.get(1);
        System.err.println("get 1 " + integer4);
        System.err.println("get 1 " + hashMap.size());
        Integer integer5 = hashMap.get(2);
        System.err.println("get 2 " + integer5);
    }

    @Test
    public void testList() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i =0; i< 6;i++){
            hashMap.put(i, i);
        }
        System.err.println(hashMap.size());
        List<Integer> list1 = hashMap.listKeys();
        for (Integer integer : list1){
            System.err.print(" " + integer);
        }
        System.err.println();
        System.err.println("size " + hashMap.size());
        List<Integer> list2 = hashMap.listValues();
        for (Integer integer : list2){
            System.err.print(" " +integer);
        }
    }

    @Test
    public void testPop(){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.put(3, 3);
        Integer integer1 = hashMap.popValue();
        hashMap.popValue();


        System.err.println(integer1);
        System.err.println(hashMap.size());
        List<Integer> list1 = hashMap.listKeys();
        for (Integer integer : list1){
            System.err.print(integer + " ");
        }
        List<Integer> list2 = hashMap.listValues();
        for (Integer integer : list2){
            System.err.print(integer + " ");
        }

    }

    @Test
    public void testRemove(){
        HashMap<Integer, Integer> hash = new HashMap<>();
        hash.put(2, 2);
        hash.put(3, 3);
        hash.put(4, 4);
        Integer integer = hash.remove(2);
        System.err.println(integer);
        System.err.println(hash.size());

        List<Integer> list2 = hash.listValues();
        for (Integer integer2 : list2){
            System.err.print(integer2 + " ");
        }
    }
}
