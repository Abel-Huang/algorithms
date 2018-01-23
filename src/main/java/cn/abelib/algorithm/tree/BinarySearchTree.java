package cn.abelib.algorithm.tree;

import java.util.List;

/**
 * Created by abel-huang on 17/10/30.
 */
public class BinarySearchTree {
    public TreeNode root = null;
    private class TreeNode{
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int value){
            this.value = value;
        }
    }

//    public BinarySearchTree(TreeNode root){
//        this.root = root;
//    }

    public boolean insertNode(List<Integer> dataList){
        if (dataList == null|| dataList.size() == 0){
            return false;
        }
        for (int i : dataList){
            insertNode(dataList);
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

    public void visitTree(BinarySearchTree bst){
        inorderVisit(bst.root);
    }

    private void inorderVisit(TreeNode  root){
        if (root == null){
            return;
        }
        System.err.println(root.value + "-->");
        inorderVisit(root.left);
        inorderVisit(root.right);
    }

    public static void main(String [] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertNode(3);
        bst.insertNode(1);
        bst.insertNode(2);
        bst.insertNode(4);
        bst.visitTree(bst);
    }
}
