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
    }

    @Test
    public void binarySearchInternalNodeTest() {
        KeyValue entry = new KeyValue("f", "hello");

        List<KeyValue> keyValues = new ArrayList<>();
        keyValues.add(new KeyValue("a", "word"));
        keyValues.add(new KeyValue("c", "tree"));
        keyValues.add(new KeyValue("d", "balance"));

        System.out.println(balancePlusTree.binarySearchInternalNode(entry, keyValues));
    }

    /**
     * todo 待验证
     */
    @Test
    public void insertTest() {
        balancePlusTree.insert(new KeyValue("a", "word"));
        balancePlusTree.insert(new KeyValue("c", "tree"));
        balancePlusTree.insert(new KeyValue("d", "balance"));
        balancePlusTree.insert(new KeyValue("b", "hello"));
    }
}
