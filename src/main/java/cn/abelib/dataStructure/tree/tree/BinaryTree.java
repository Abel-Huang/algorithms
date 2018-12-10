package cn.abelib.dataStructure.tree.tree;

import java.util.List;

/**
 * Created by abel-huang on 17/10/30.
 */
public class BinaryTree {
    private TreeNode root = null;
    private boolean tag = false;
    private class TreeNode{
        private int value;
        private TreeNode left;
        private TreeNode right;
        private TreeNode(int value){
            this.value = value;
        }
    }

    /**
     *  批量插入
     * @param dataList
     */
    public void inserts(List<Integer> dataList){
        if (dataList == null|| dataList.size() == 0){
            return;
        }
        for (int i : dataList){
            insert(i);
        }
    }

    /**
     *  非递归插入
     * @param value
     */
    public void insert(int value){
        if (root == null){
            root = new TreeNode(value);
            return;
        }
        TreeNode current = root;
        while(current != null ){
            if (current.value > value){
                if (current.left != null){
                    current = current.left;
                }else {
                    current.left = new TreeNode(value);
                    break;
                }
            }
            else if (current.value < value){
                if (current.right != null){
                    current =current.right;
                }else {
                    current.right = new TreeNode(value);
                    break;
                }
            }
        }
    }

    /**
     *  递归插入
     * @param value
     */
    public void insertRecursion(int value){
        root = insertRecursion(root, value);
    }

    private TreeNode insertRecursion(TreeNode originalNode, int value) {
        if (originalNode == null) {
            return new TreeNode(value);
        }
        // 如果插入的值小于当前结点
        if (originalNode.value > value) {
            originalNode.left = insertRecursion(originalNode.left, value);
            // 如果插入的值大于当前结点
        } else if (originalNode.value < value) {
            originalNode.right = insertRecursion(originalNode.right, value);
        } else {
            originalNode.value = value;
        }
        return originalNode;
    }

    /**
     *  查看是否包含元素value
     * @param value
     * @return
     */
    public boolean contain(int value){
        contain(root, value);
        return tag;
    }

    private void contain(TreeNode  originalNode, int value){
        if (originalNode == null){
            return;
        }
        contain(originalNode.left, value);
        if (originalNode.value == value){
            tag = true;
        }
        contain(originalNode.right, value);
    }

    public void visitTree(){
        inOrderVisitRecursion(root);
    }

    /**
     *  递归中序遍历
     * @param originalNode
     */
    public void inOrderVisitRecursion(TreeNode  originalNode){
        if (originalNode == null){
            return;
        }
        inOrderVisitRecursion(originalNode.left);
        System.err.println(originalNode.value + "-->");
        inOrderVisitRecursion(originalNode.right);
    }

    /**
     *  非递归中序遍历
     * @param originalNode
     */
    public void inOrderVisit(TreeNode  originalNode){

    }

    /**
     *  递归前序遍历
     * @param originalNode
     */
    public void preOrderVisitRecursion(TreeNode  originalNode){
        if (originalNode == null){
            return;
        }
        System.out.println(originalNode.value + "-->");
        preOrderVisitRecursion(originalNode.left);

        preOrderVisitRecursion(originalNode.right);
    }

    /**
     *  非递归前序遍历
     * @param originalNode
     */
    public void preOrderVisit(TreeNode  originalNode){

    }

    /**
     *  递归后序遍历
     * @param originalNode
     */
    public void postOrderVisitRecursion(TreeNode  originalNode){
        if (originalNode == null){
            return;
        }
        postOrderVisitRecursion(originalNode.left);
        postOrderVisitRecursion(originalNode.right);
        System.out.println(originalNode.value + "-->");
    }

    /**
     *  非递归后序遍历
     * @param originalNode
     */
    public void postOrderVisit(TreeNode  originalNode){

    }
}
