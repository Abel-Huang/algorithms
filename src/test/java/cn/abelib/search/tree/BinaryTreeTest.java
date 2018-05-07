package cn.abelib.search.tree;

import org.junit.Test;

import java.util.Arrays;


/**
 * Created by abel on 2017/11/8.
 */
public class BinaryTreeTest {
    @Test
    public void insertTest(){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(5);
        binaryTree.insert(3);
        binaryTree.insert(2);
        binaryTree.insert(6);
        binaryTree.insert(4);
        binaryTree.insert(1);
        binaryTree.visitTree();
    }

    @Test
    public void insertRecursionTest(){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertRecursion(5);
        binaryTree.insertRecursion(3);
        binaryTree.insertRecursion(2);
        binaryTree.insertRecursion(6);
        binaryTree.insertRecursion(4);
        binaryTree.insertRecursion(1);
        binaryTree.visitTree();
    }

    @Test
    public void containTest(){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.inserts(Arrays.asList(5, 3, 2, 6, 4, 1));
        System.err.println(binaryTree.contain(7));
    }
}
