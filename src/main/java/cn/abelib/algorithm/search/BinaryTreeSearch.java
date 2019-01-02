package cn.abelib.algorithm.search;

import java.util.Iterator;

/**
 * @author abel
 */
public class BinaryTreeSearch<K extends Comparable<K>, V> implements Iterable<K> {
    private Node root;

    private  class Node{
        private K key;
        private V value;
        private Node left, right;
        private int N;

        public Node(K key, V value, int N){
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node node){
       return node == null?0:node.N;
    }

    public V get(K k){
        return get(root, k);
    }

    private V get(Node node, K key){
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if(cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    public void put(K key, V value){
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value){
        if (node == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public Iterator<K> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<K> {
        private Node current=root;
        @Override
        public boolean hasNext() {
            return current!=null;
        }
        @Override
        public K next() {
            K item=(K)next(current).key;
            return item;
        }
        private Node next(Node node){
            if (current != null){
                next(current = current.left);
                next(current = current.right);
                return current;
            }
            return null;
        }
        @Override
        public void remove(){}
    }
}
