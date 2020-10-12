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
     * 后继指针
     */
    private TreeNode nextNode;
    /**
     * 前驱指针
     */
    private TreeNode prevNode;
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

    @Override
    public String toString() {
        return "TreeNode{" +
                "keyValues=" + keyValues +
                ", nextNode=" + nextNode +
                ", prevNode=" + prevNode +
                ", parentNode=" + parentNode +
                '}';
    }
}
