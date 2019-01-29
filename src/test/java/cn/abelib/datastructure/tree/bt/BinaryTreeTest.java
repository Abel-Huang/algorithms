package cn.abelib.datastructure.tree.bt;

import cn.abelib.util.annotation.Tested;
import cn.abelib.util.annotation.UnFinish;
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
    public void init() {
        binaryTree = new BinaryTree<>();
        System.out.println(binaryTree.isEmpty());
        binaryTree.add(4);
        binaryTree.add(2);
        binaryTree.add(5);
        binaryTree.add(1);
        binaryTree.add(3);
        System.out.println(binaryTree.isEmpty());
    }

    @Test
    @Tested
    public void addTest() {
        binaryTree.addRecursion(7);
        binaryTree.addRecursion(6);
        System.out.println(binaryTree.size());
        binaryTree.forEach(System.out::println);
    }

    @Test
    @Tested
    public void sizeTest() {
        System.out.println(binaryTree.size());
    }

    @Test
    @Tested
    public void containsTest() {
        System.out.println(binaryTree.contains(1));
        System.out.println(binaryTree.contains(2));
        System.out.println(binaryTree.contains(3));
        System.out.println(binaryTree.contains(4));
        System.out.println(binaryTree.contains(4));
        System.out.println(binaryTree.contains(5));
    }

    @Test
    @Tested
    public void maxTest() {
        binaryTree.add(0);
        binaryTree.add(6);
        System.out.println(binaryTree.max());
    }

    @Test
    @Tested
    public void minTest() {
        binaryTree.add(0);
        binaryTree.add(6);
        System.out.println(binaryTree.min());
    }

    @Test
    @Tested
    public void removeMinTest() {
        System.out.println(binaryTree.preOrderVisit());
        System.out.println(binaryTree.removeMin());
        System.out.println(binaryTree.preOrderVisit());
        System.out.println(binaryTree.size());
    }

    @Test
    @Tested
    public void removeMaxTest() {
        System.out.println(binaryTree.preOrderVisit());
        System.out.println(binaryTree.removeMax());
        System.out.println(binaryTree.preOrderVisit());
        System.out.println(binaryTree.size());
    }

    @Test
    @Tested
    public void levelVisitTest() {
        binaryTree.add(0);
        binaryTree.add(6);
        System.out.println(binaryTree.levelOrderVisit());
    }

    @Test
    @Tested
    public void inOrderVisitRecursionTest() {
        System.out.println(binaryTree.inOrderVisitRecursion());
    }

    @Test
    @UnFinish
    public void inOrderVisitTest() {
        System.out.println(binaryTree.inOrderVisit());
    }

    @Test
    @Tested
    public void preOrderVisitRecursionTest() {
        System.out.println(binaryTree.preOrderVisitRecursion());
    }

    @Test
    @Tested
    public void preOrderVisitTest() {
        binaryTree.addRecursion(7);
        binaryTree.addRecursion(6);
        System.out.println(binaryTree.preOrderVisit());
    }

    @Test
    @Tested
    public void postOrderVisitRecursionTest() {
        System.out.println(binaryTree.postOrderVisitRecursion());
    }

    @Test
    @Tested
    public void traverseTest() {
        binaryTree.forEach(System.out::println);
    }
}
