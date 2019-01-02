package cn.abelib.datastructure.tree.binary;

import cn.abelib.util.annotation.Tested;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: abel-huang
 * @Date: 2018-12-27 22:46
 */
public class BinaryTreeTest {
    private BinaryTree<Integer> binaryTree;
    ////////////////////
    //        4       //
    //      /   \     //
    //     2     5    //
    //   /   \        //
    //  1     3       //
    ////////////////////
    @Before
    public void init(){
        binaryTree = new BinaryTree<>();
        binaryTree.add(4);
        binaryTree.add(2);
        binaryTree.add(5);
        binaryTree.add(1);
        binaryTree.add(3);
    }

    @Test
    @Tested
    public void sizeTest(){
        System.out.println(binaryTree.size());
    }

    @Test
    @Tested
    public void containsTest(){
        System.out.println(binaryTree.contains(1));
        System.out.println(binaryTree.contains(2));
        System.out.println(binaryTree.contains(3));
        System.out.println(binaryTree.contains(4));
        System.out.println(binaryTree.contains(4));
        System.out.println(binaryTree.contains(5));
    }

    @Test
    @Tested
    public void inOrderVisitRecursionTest(){
        System.out.println(binaryTree.inOrderVisitRecursion());
    }

    @Test
    @Tested
    public void preOrderVisitRecursionTest(){
        System.out.println(binaryTree.preOrderVisitRecursion());
    }

    @Test
    @Tested
    public void postOrderVisitRecursionTest(){
        System.out.println(binaryTree.postOrderVisitRecursion());
    }

    @Test
    public void traverseTest(){
        binaryTree.forEach(System.out::println);
    }
}
