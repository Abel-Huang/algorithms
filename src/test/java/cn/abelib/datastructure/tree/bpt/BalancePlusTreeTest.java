package cn.abelib.datastructure.tree.bpt;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author abel.huang
 * @date 2020/10/9 14:42
 */
public class BalancePlusTreeTest {
    private BalancePlusTree balancePlusTree;

    @Before
    public void init() {
        balancePlusTree = new BalancePlusTree(5);

        balancePlusTree.insert("a", "word");
        balancePlusTree.insert("c", "tree");
        balancePlusTree.insert("d", "balance");
        balancePlusTree.insert("b", "hello");
        balancePlusTree.insert("e", "plus");
        balancePlusTree.insert("f", "database");
        balancePlusTree.insert("g", "memory");
        balancePlusTree.insert("h", "disk");
    }

    @Test
    public void binarySearchInternalNodeTest() {
        List<KeyValue> keyValues = new ArrayList<>();
        keyValues.add(new KeyValue("a", "word"));
        keyValues.add(new KeyValue("c", "tree"));
        keyValues.add(new KeyValue("d", "balance"));
        keyValues.add(new KeyValue("e", "ping"));
        keyValues.add(new KeyValue("f", "pong"));
        keyValues.add(new KeyValue("h", "hard"));
        System.out.println(balancePlusTree.binarySearchInternalNode(new KeyValue("f", "hello"), keyValues));
        System.out.println(balancePlusTree.binarySearchInternalNode(new KeyValue("b", "hello"), keyValues));
        System.out.println(balancePlusTree.binarySearchInternalNode(new KeyValue("Z", "hello"), keyValues));
        System.out.println(balancePlusTree.binarySearchInternalNode(new KeyValue("a", "hello"), keyValues));
    }

    @Test
    public void binarySearchInternalNode2Test() {
        List<KeyValue> keyValues = new ArrayList<>();
        keyValues.add(new KeyValue("a", "word"));
        keyValues.add(new KeyValue("c", "tree"));
        keyValues.add(new KeyValue("d", "balance"));
        keyValues.add(new KeyValue("e", "ping"));
        keyValues.add(new KeyValue("f", "pong"));
        keyValues.add(new KeyValue("h", "hard"));
        System.out.println(balancePlusTree.binarySearchInternalNode2(new KeyValue("f", "hello"), keyValues));
        System.out.println(balancePlusTree.binarySearchInternalNode2(new KeyValue("b", "hello"), keyValues));
        System.out.println(balancePlusTree.binarySearchInternalNode2(new KeyValue("a", "hello"), keyValues));
        System.out.println(balancePlusTree.binarySearchInternalNode2(new KeyValue("i", "hello"), keyValues));
    }

    @Test
    public void subListTest() {
        List<KeyValue> keyValues = new ArrayList<>();
        keyValues.add(new KeyValue("a", "word"));
        keyValues.add(new KeyValue("c", "tree"));
        keyValues.add(new KeyValue("d", "balance"));
        keyValues.add(new KeyValue("b", "hello"));
        keyValues.add(new KeyValue("e", "plus"));

        System.out.println(keyValues.subList(0, 2));
    }

    @Test
    public void insertTest() {
        System.out.println(balancePlusTree.toList());
    }

    @Test
    public void searchTest() {
        System.out.println(balancePlusTree.search("b"));
    }

    @Test
    public void scanTest() {
        System.out.println(balancePlusTree.scan("b", "d"));
    }

    @Test
    public void updateTest() {
        System.out.println(balancePlusTree.toList());
        balancePlusTree.update("a", "database");
        System.out.println(balancePlusTree.toList());
        balancePlusTree.insert("a", "index");
        System.out.println(balancePlusTree.toList());
        balancePlusTree.insert("a", "binary");
        System.out.println(balancePlusTree.toList());
    }

    @Test
    public void borrowTest() {
        TreeNode parent = new TreeNode();
        parent.getKeyValues().add(new KeyValue("7"));
        parent.getKeyValues().add(new KeyValue("10"));

        TreeNode rightNode = new TreeNode();
        rightNode.getKeyValues().add(new KeyValue("10"));

        TreeNode leftNode = new TreeNode();
        leftNode.getKeyValues().add(new KeyValue("7"));
        leftNode.getKeyValues().add(new KeyValue("8"));
        leftNode.getKeyValues().add(new KeyValue("9"));

        balancePlusTree.borrowFromLeft(parent, leftNode, rightNode, 0);
    }

    @Test
    public void mergeTest() {
        TreeNode parent = new TreeNode();
        parent.getKeyValues().add(new KeyValue("7"));
        parent.getKeyValues().add(new KeyValue("9"));


        TreeNode rightNode = new TreeNode();
        rightNode.getKeyValues().add(new KeyValue("8"));

        TreeNode leftNode = new TreeNode();
        leftNode.getKeyValues().add(new KeyValue("5"));
        leftNode.getKeyValues().add(new KeyValue("6"));

        parent.getChildren().add(leftNode);
        parent.getChildren().add(rightNode);
        balancePlusTree.mergeExternalNode(parent, leftNode, rightNode, 0);
    }


    @Test
    public void ceilTest() {
        System.err.println((int)Math.ceil(balancePlusTree.getDegree() / 2.0) - 1);
    }

    @Test
    public void deleteTest() {
        balancePlusTree.delete("d");
        System.err.println(balancePlusTree.toList());
    }

}