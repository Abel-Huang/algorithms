package cn.abelib.datastructure.tree.tree;

import cn.abelib.datastructure.tree.binary.SimpleRedBlackTree;
import org.junit.Test;

/**
 * Created by abel on 2018/5/7.
 */
public class SimpleRedBlackTreeTest {
    @Test
    public void insertTest() {
        SimpleRedBlackTree rbTree = new SimpleRedBlackTree();
        rbTree.insert(5);
        rbTree.insert(3);
        rbTree.insert(2);
        rbTree.insert(6);
        rbTree.insert(4);
        rbTree.insert(1);
        rbTree.visitTree();
    }
}
