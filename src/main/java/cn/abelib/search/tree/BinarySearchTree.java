package cn.abelib.search.tree;

import java.util.List;

/**
 * Created by abel-huang on 17/10/30.
 */
public class BinarySearchTree {
    private TreeNode root = null;
    private class TreeNode{
        private int value;
        private TreeNode left;
        private TreeNode right;
        private TreeNode(int value){
            this.value = value;
        }
    }

    public boolean insertNode(List<Integer> dataList){
        if (dataList == null|| dataList.size() == 0){
            return false;
        }
        for (int i : dataList){
            insertNode(i);
        }
        return true;
    }

    public boolean insertNode(int data){
        if (root == null){
            root = new TreeNode(data);
            return true;
        }
        TreeNode current = root;
        while(current != null ){
            if (current.value > data){
                if (current.left != null){
                    current = current.left;
                }else {
                    current.left = new TreeNode(data);
                    break;
                }
            }
            else if (current.value < data){
                if (current.right != null){
                    current =current.right;
                }else {
                    current.right = new TreeNode(data);
                    break;
                }
            }
        }
        return true;
    }

    public void visitTree(){
        inorderVisit(root);
    }

    private void inorderVisit(TreeNode  root){
        if (root == null){
            return;
        }
        inorderVisit(root.left);
        System.err.println(root.value + "-->");
        inorderVisit(root.right);
    }

    //todo
    public boolean contain(BinarySearchTree bst, int data){
        if (root == null){
            return false;
        }
        inorderVisit(root.left);
        System.err.println(root.value + "-->");
        inorderVisit(root.right);
        return false;
    }
}
