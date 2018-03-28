package cn.abelib.search.alg;

import java.util.ArrayList;
import java.util.Arrays;
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

    public void visitTree(BinarySearchTree bst){
        inorderVisit(bst.root);
    }

    private void inorderVisit(TreeNode  root){
        if (root == null){
            return;
        }
        inorderVisit(root.left);
        System.err.println(root.value + "-->");
        inorderVisit(root.right);
    }

    public boolean contain(BinarySearchTree bst, int data){
        if (root == null){
            return false;
        }
        inorderVisit(root.left);
        System.err.println(root.value + "-->");
        inorderVisit(root.right);
    }

    public static void main(String [] args){
        BinarySearchTree bst = new BinarySearchTree();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        bst.insertNode(list);
        bst.visitTree(bst);
    }
}
