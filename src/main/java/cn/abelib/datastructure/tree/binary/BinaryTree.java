package cn.abelib.datastructure.tree.binary;

import cn.abelib.datastructure.linear.linked.LinkedList;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author abel-huang
 * @date 17/10/30
 */
public class BinaryTree<T extends Comparable<T>> implements Iterable<T> {
    private TreeNode root;
    private int size;

    private class TreeNode{
        private T value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(T value){
            this.value = value;
            left = null;
            right = null;
        }
    }

    public BinaryTree(){
        root = null;
        size = 0;
    }

    /**
     * tree size
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * tree is empty or not
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     *  批量插入
     * @param items
     */
    public void add(Collection<T> items){
        if (items == null|| items.size() == 0){
            return;
        }
        for (T item : items){
            add(item);
        }
    }

    /**
     *  非递归插入
     * @param item
     */
    public void add(T item){
        if (root == null){
            root = new TreeNode(item);
            size++;
            return;
        }
        TreeNode current = root;
        while(current != null ){
            if (current.value.compareTo(item) > 0){
                if (current.left != null){
                    current = current.left;
                }else {
                    current.left = new TreeNode(item);
                    size++;
                    break;
                }
            } else if (current.value.compareTo(item) < 0){
                if (current.right != null){
                    current =current.right;
                }else {
                    current.right = new TreeNode(item);
                    size++;
                    break;
                }
            }
        }
    }

    /**
     *  递归插入
     * @param item
     */
    public void addRecursion(T item){
        root = addRecursion(root, item);
    }

    /**
     * @param node
     * @param item
     * @return
     */
    private TreeNode addRecursion(TreeNode node, T item) {
        if (node == null) {
            size++;
            return new TreeNode(item);
        }
        // 如果插入的值小于当前结点
        if (node.value.compareTo(item) > 0) {
            node.left = addRecursion(node.left, item);
            // 如果插入的值大于当前结点
        } else if (node.value.compareTo(item) < 0) {
            node.right = addRecursion(node.right, item);
        }
        return node;
    }

    /**
     *  查看是否包含元素value
     * @param item
     * @return
     */
    public boolean contains(T item){
        return contains(root, item);
    }

    private boolean contains(TreeNode  node, T item){
        if (node == null){
            return false;
        }
        if (node.value.compareTo(item) > 0) {
            return contains(node.left, item);
        } else if (node.value.compareTo(item) == 0){
            return true;
        } else {
            return contains(node.right, item);
        }
    }

    public LinkedList<T> inOrderVisitRecursion(){
        LinkedList<T> nodes = new LinkedList<>();
        inOrderVisitRecursion(root, nodes);
        return nodes;
    }

    /**
     *  递归中序遍历
     * @param originalNode
     */
    private void inOrderVisitRecursion(TreeNode  originalNode, LinkedList<T> nodes){
        if (originalNode == null){
            return;
        }
        inOrderVisitRecursion(originalNode.left,  nodes);
        nodes.add(originalNode.value);
        inOrderVisitRecursion(originalNode.right, nodes);
    }

    public LinkedList<T> inOrderVisit(){
        LinkedList<T> nodes = new LinkedList<>();
        inOrderVisit(root, nodes);
        return nodes;
    }

    /**
     *  非递归中序遍历
     * @param originalNode
     */
    private void inOrderVisit(TreeNode  originalNode, LinkedList<T> nodes){

    }

    public LinkedList<T> preOrderVisitRecursion(){
        LinkedList<T> nodes = new LinkedList<>();
        preOrderVisitRecursion(root, nodes);
        return nodes;
    }

    /**
     *  递归前序遍历
     * @param originalNode
     */
    private void preOrderVisitRecursion(TreeNode  originalNode, LinkedList<T> nodes){
        if (originalNode == null){
            return;
        }
        nodes.add(originalNode.value);
        preOrderVisitRecursion(originalNode.left, nodes);
        preOrderVisitRecursion(originalNode.right, nodes);
    }

    public LinkedList<T> preOrderVisit(){
        LinkedList<T> nodes = new LinkedList<>();
        preOrderVisit(root, nodes);
        return nodes;
    }

    /**
     *  非递归前序遍历
     * @param originalNode
     */
    private void preOrderVisit(TreeNode  originalNode,  LinkedList<T> nodes){

    }

    public  LinkedList<T> postOrderVisitRecursion(){
        LinkedList<T> nodes = new LinkedList<>();
        postOrderVisitRecursion(root, nodes);
        return nodes;
    }

    /**
     *  递归后序遍历
     * @param originalNode
     */
    private void postOrderVisitRecursion(TreeNode  originalNode, LinkedList<T> nodes){
        if (originalNode == null){
            return;
        }
        postOrderVisitRecursion(originalNode.left, nodes);
        postOrderVisitRecursion(originalNode.right, nodes);
        nodes.add(originalNode.value);
    }

    public  LinkedList<T> postOrderVisit(){
        LinkedList<T> nodes = new LinkedList<>();
        postOrderVisit(root, nodes);
        return nodes;
    }

    /**
     *  非递归后序遍历
     * @param originalNode
     */
    private void postOrderVisit(TreeNode  originalNode, LinkedList<T> nodes){

    }


    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        private int i = 0;
        private LinkedList<T> nodes = inOrderVisit();

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public T next() {
            return nodes.get(i);
        }

        @Override
        public void remove(){}
    }
}
