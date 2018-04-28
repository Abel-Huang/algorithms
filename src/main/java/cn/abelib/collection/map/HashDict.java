package cn.abelib.collection.map;


import cn.abelib.commons.MurmurHash2;
import cn.abelib.commons.Constant;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by abel-huang on 18/3/8.
 * 模仿redis底层实现的HashMap
 */
public class HashDict<K, V> {
    private HashTable ht;
    private HashTable expand;
    private int rehash;


    public HashDict(){
        this.ht = new HashTable();
        this.expand = null;
        this.rehash = -1;
    }

    public HashDict(int capacity){
        this.ht = new HashTable(capacity);
        this.expand = null;
        this.rehash = -1;
    }

    /**
     *  node key hash
     * @return
     */
    private int hash(K key){
        long code = MurmurHash2.hash(key.toString());
        return (int) code;
    }

    /**
     *  cal index in the ht
     * @param key
     * @return
     */
    private int index(K key){
        return hash(key)&ht.mask;
    }

    /**
     * cal index for this mask
     * @param key
     * @param mask
     * @return
     */
    private int index(K key, int mask){
        return hash(key)&mask;
    }

    /**
     *  capacity
     * @return
     */
    public int capacity(){
        return this.rehash==-1?ht.capacity:expand.capacity;
    }

    /**
     *  size
     * @return
     */
    public int size(){
        return this.rehash==-1?ht.size:ht.size + expand.size;
    }

    private boolean put0(K key, V value, HashTable<K, V> hashTable){
        int index = index(key, hashTable.mask);
        NodeEntry<K, V> head = hashTable.table[index];
        V goal = this.get(key);
        if (goal != null){
            while (head.next != null){
                head = head.next;
                if (head.key.equals(key)){
                    head.value = value;
                    return true;
                }
            }
        }
        NodeEntry<K, V> node = new NodeEntry<>(key, value);
        while (head.next != null){
            head = head.next;
        }
        head.next = node;
        node.next = null;
        hashTable.size++;
        return true;
    }

    public boolean put(K key, V value){
        putRehash();
        if (this.rehash != -1){
            this.rehash();
           return this.put0(key, value, expand);
        }else {
            return this.put0(key, value, ht);
        }
    }

//    private V get0(K key, V value, HashTable<K, V> hashTable){
//        int index = index(key, expand.mask);
//        NodeEntry<K, V> head = expand.table[index];
//        while (head.next != null){
//            head = head.next;
//            if (head.key.equals(key)) {
//                return head.value;
//            }
//        }
//        return
//    }

    public V get(K key){
        if (this.rehash != -1 && expand != null){
            this.rehash();
            int index = index(key, expand.mask);
            NodeEntry<K, V> head = expand.table[index];
            while (head.next != null){
                head = head.next;
                if (head.key.equals(key)) {
                    return head.value;
                }
            }
        }
        int index = index(key);
        NodeEntry<K, V> head = ht.table[index];
        while (head.next != null){
            head = head.next;
            if (head.key.equals(key)) {
                return head.value;
            }
        }
        return null;
    }

    /**
     *  判断是否需要rehash
     * @return
     */
    private int shouldRehash0(){
        if (ht.size > 2 * ht.capacity)
            return 1;
        else if (ht.size < ht.capacity/10)
            return -1;
        else
            return 0;
    }

    /**
     *  进行rehash
     */
    private void putRehash(){
        if (this.rehash == -1){
            if (this.shouldRehash0() > 0){
                this.rehash(ht.capacity * 2);
            }
        }
    }

    private void popRehash(){
        if (this.rehash == -1){
            if (this.shouldRehash0() < 0 && this.size() > Constant.DEFAULT_CAPACITY){
                int capacity = ht.capacity;
                while (true){
                    capacity =capacity/2;
                    if (capacity <= this.size())
                        break;
                }
                capacity*=2;
                capacity = capacity<Constant.DEFAULT_CAPACITY?Constant.DEFAULT_CAPACITY:capacity;
                this.rehash(capacity);
            }
        }
    }



    /**
     *  list all keys disorder
     * @return
     */
    public List<K> listKeys(){
        List<K> keysList = new LinkedList<>();
        if (this.rehash != -1){
            for (int i =0; i< expand.capacity; i++){
                NodeEntry<K, V> nodeEntry = expand.table[i].next;
                while (nodeEntry != null){
                    keysList.add(nodeEntry.key);
                    nodeEntry = nodeEntry.next;
                }
            }
        }
        for (int i =0; i< ht.capacity; i++){
            NodeEntry<K, V> nodeEntry = ht.table[i].next;
            while (nodeEntry != null){
                keysList.add(nodeEntry.key);
                nodeEntry = nodeEntry.next;
            }
        }
        return keysList;

    }

    /**
     *  list all values disorder
     * @return
     */
    public List<V> listValues(){
        List<V> valuesList = new LinkedList<>();
        List<K> keysList = this.listKeys();
        for (K key : keysList){
            valuesList.add(this.get(key));
        }
        return valuesList;
    }

    /**
     *  弹出dict中的一个元素，并且将其删除
     * @return
     */
    private NodeEntry<K, V> pop(){
        if (this.ht.size < 1)
            throw new RuntimeException("Dict is already empty!");
        NodeEntry<K, V> nodeEntry = null;
        for (int i =0; i< ht.capacity; i++){
            if ( ht.table[i].next != null) {
                nodeEntry = ht.table[i].next;
                ht.table[i].next = ht.table[i].next.next;
                ht.size--;
                break;
            }
        }
        return nodeEntry;
    }

    public V popValue(){
        return this.pop().value;
    }

    private boolean rehash(int capacity){
        if (this.rehash == -1){
            this.expand = new HashTable(capacity);
        }
        return this.rehash();
    }

    private boolean rehash(){
        if (ht.size > 0){
            NodeEntry<K, V> nodeEntry = this.pop();
            this.put0(nodeEntry.key, nodeEntry.value, expand);
        }
        this.rehash++;
        if (ht.size < 1){
            ht = expand;
            expand = null;
            this.rehash = -1;
        }
        return true;
    }

    public V remove(K key){
        popRehash();
        if (this.rehash != -1){
            this.rehash();
            int index = index(key, expand.mask);
            NodeEntry<K, V> head = expand.table[index];
            NodeEntry<K, V> result = null;
            while (head != null){
                if (head.next.key.equals(key)) {
                    result = head.next;
                    head.next = head.next.next;
                    expand.size--;
                    return result.value;
                }
                head = head.next;
            }
        }
        int index = index(key);
        NodeEntry<K, V> head = ht.table[index];
        NodeEntry<K, V> result = null;
        while (head != null){
            if (head.next.key.equals(key)) {
                result = head.next;
                head.next = head.next.next;
                ht.size--;
                return result.value;
            }
            head = head.next;
        }
        return null;
    }

    //字典的内部hash表实现
    private class HashTable<K, V>{
        NodeEntry[] table;
        int capacity;
        int size;
        int mask;
        HashTable(){
            this(Constant.DEFAULT_CAPACITY);
        }

        HashTable(int capacity){
            this.capacity = capacity;
            this.size = 0;
            this.mask = capacity - 1;
            table = new NodeEntry[capacity];
            for (int i=0; i< capacity; i++){
                NodeEntry<K, V> empty = new NodeEntry<K, V>();
                empty.next = null;
                empty.key = null;
                empty.key = null;
                table[i] = empty;
            }
        }
    }


    // 字典的内部节点实现
    private class NodeEntry<K, V>{
        NodeEntry<K, V> next;
        K key;
        V value;

        NodeEntry(){

        }

        NodeEntry(K key, V value){
            this.key = key;
            this.value = value;
        }

        NodeEntry(K key, V value, NodeEntry<K, V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
