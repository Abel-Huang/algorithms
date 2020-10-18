package cn.abelib.datastructure.tree.bpt;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author abel.huang
 * @date 2020/10/9 14:42
 */
public class BalancePlusTree2Test {
    private BalancePlusTree balancePlusTree;

    @Before
    public void init() {
        balancePlusTree = new BalancePlusTree(5);
    }

    @Test
    public void insertTest() {
        balancePlusTree.insert("a");
        balancePlusTree.insert("d");
        balancePlusTree.insert("f");
        balancePlusTree.insert("g");
        balancePlusTree.insert("h");
        balancePlusTree.insert("i");
        balancePlusTree.insert("j");
        balancePlusTree.insert("b");
        balancePlusTree.insert("e");
        balancePlusTree.insert("k");
        balancePlusTree.insert("l");
        balancePlusTree.insert("m");
        balancePlusTree.insert("n");
        balancePlusTree.insert("c");
        System.out.println(balancePlusTree.toList());
        balancePlusTree.delete("n");
        System.out.println(balancePlusTree.toList());
        balancePlusTree.delete("g");
        System.out.println(balancePlusTree.toList());
        balancePlusTree.delete("c");
        System.out.println(balancePlusTree.toList());
    }
}