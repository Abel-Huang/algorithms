package cn.abelib.datastructure.tree.avl;


import cn.abelib.datastructure.tree.bst.BinaryTree;


/**
 * @Author: abel.huang
 * @Date: 2019-02-01 00:37
 */
public class AvlTree<T extends Comparable<T>> extends BinaryTree<T> {
    private AvlNode root;

    public AvlTree() {
        root = null;
        size = 0;
    }

    private class AvlNode {
        private T value;
        private AvlNode left;
        private AvlNode right;
        private int height;

        private AvlNode(T value) {
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    /**
     *  获得当前节点的高度
     * @param node
     * @return
     */
    private int getHeight(AvlNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalanceFactor() {
        return 0;
    }
}
