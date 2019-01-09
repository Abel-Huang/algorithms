package cn.abelib.datastructure.map;


import cn.abelib.datastructure.tree.binary.BinaryTree;

/**
 * @author abel-huang
 * @date 2017/12/25
 * BinaryTreeMap
 */
public class BinaryTreeMap<K, V> implements Map<K, V>{
    private BinaryTree<K, V>> binaryTree;
//
//    public BinaryTreeMap() {
//        binaryTree = new BinaryTree<>();
//    }
//
//    private class Entry<K, V> implements Comparable {
//        K key;
//        V value;
//
//        Entry() {
//
//        }
//
//        Entry(K key, V value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        @Override
//        public int compareTo(K key) {
//            if(this.key.hashCode() < key.hashCode()){
//                return -1;
//            }
//            if(this.key.hashCode() > key.hashCode()){
//                return 1;
//            }
//            return 0;
//        }
//    }

    @Override
    public int size() {
        return binaryTree.size();
    }

    @Override
    public boolean put(K key, V value) {
        binaryTree.add();
        return false;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void set(K key, V value) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public V remove(K key) {
        return null;
    }
}
