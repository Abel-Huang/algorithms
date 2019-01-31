package cn.abelib.datastructure.tree.btree;

import java.util.ArrayList;

/**
 * @author abel-huang
 * @date 2017/11/2
 * B+树的简单实现
 */
public class BalancePlusTree<T> {
    private class TreeNode {
        private boolean isLeaf;
        private TreeNode parent;
        private ArrayList<T> keys;
        private ArrayList<TreeNode> childNodes;
    }
}
