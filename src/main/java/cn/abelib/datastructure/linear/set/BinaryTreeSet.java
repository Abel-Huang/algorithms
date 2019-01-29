package cn.abelib.datastructure.linear.set;


import cn.abelib.datastructure.tree.binary.BinaryTree;

/**
 * @author abel-huang
 * @date 2017/7/10
 */
public class BinaryTreeSet<T extends Comparable<T>> implements Set<T> {
    private BinaryTree<T> binaryTree;

    public BinaryTreeSet(){
        binaryTree = new BinaryTree<>();
    }

    @Override
    public void add(T item) {
        binaryTree.add(item);
    }

    @Override
    public void remove(T item) {
        // todo
        binaryTree.remove(item);
    }

    @Override
    public boolean contains(T item) {
        return binaryTree.contains(item);
    }

    @Override
    public int size() {
        return binaryTree.size();
    }

    @Override
    public boolean isEmpty() {
        return binaryTree.isEmpty();
    }

    @Override
    public String toString() {
        return binaryTree.toString();
    }
}

