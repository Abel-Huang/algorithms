package cn.abelib.dataStructure.tree.tree;

import java.util.ArrayList;

/**
 * Created by abel-huang on 2017/11/2.
 *  B+树的简单实现
 */
public class BalancePlusTree<T> {
    private class TreeNode{
        private boolean isLeaf;
        private TreeNode parent;
        private ArrayList<T> keys;
        private ArrayList<TreeNode> childNodes;
    }

}
