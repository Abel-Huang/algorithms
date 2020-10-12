package cn.abelib.datastructure.tree.bpt;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: abel.huang
 * @Date: 2019-02-01 00:32
 */
public class TreeNode {
    /**
     * 子节点
     */
    private List<TreeNode> children;
    /**
     * 当前节点键值对集合
     */
    private List<KeyValue> keyValues;
    /**
     * 后继指针(只用于叶节点，即数据节点的链表)
     */
    private TreeNode nextNode;
    /**
     * 前驱指针(同上)
     */
    private TreeNode prevNode;
    /**
     * 是否是叶节点，叶节点即数据节点，用于存放数据，位于B+树最下面一层，
     * 非叶子节点为索引节点，存放的是从底层提升上来的索引数据，
     * 只有叶子节点才有前驱和后继指针
     */
    private boolean isLeaf;
    /**
     * 父节点
     */
    private TreeNode parentNode;

    public TreeNode(List<TreeNode> children, List<KeyValue> keyValues, TreeNode nextNode, TreeNode prevNode, TreeNode parentNode) {
        this.children = children;
        this.keyValues = keyValues;
        this.nextNode = nextNode;
        this.prevNode = prevNode;
        this.parentNode = parentNode;
    }

    public TreeNode() {
        this.children = new ArrayList<>();
        this.keyValues = new ArrayList<>();
        this.nextNode = null;
        this.prevNode = null;
        this.parentNode = null;
    }

    public  List<KeyValue> getKeyValues() {
        return this.keyValues;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public void setKeyValues(List<KeyValue> keyValues) {
        this.keyValues = keyValues;
    }

    public TreeNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(TreeNode nextNode) {
        this.nextNode = nextNode;
    }

    public TreeNode getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(TreeNode prevNode) {
        this.prevNode = prevNode;
    }

    public TreeNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(TreeNode parentNode) {
        this.parentNode = parentNode;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                ", keyValues=" + keyValues +
                ", nextNode=" + nextNode +
                ", prevNode=" + prevNode +
                ", parentNode=" + parentNode +
                '}';
    }
}
