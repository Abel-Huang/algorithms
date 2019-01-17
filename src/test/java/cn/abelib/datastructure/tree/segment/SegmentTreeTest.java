package cn.abelib.datastructure.tree.segment;

import org.junit.Before;
import org.junit.Test;




/**
 * @Author: abel.huang
 * @Date: 2019-01-18 00:22
 */
public class SegmentTreeTest {
    private SegmentTree<Integer> segmentTree;

    @Before
    public void buildTest() {
        Integer[] nums = {10, 22, 3, 34, 5, 16};
        segmentTree = new SegmentTree<>(nums, Math::max);
        System.out.println(segmentTree.get(2));

    }

    @Test
    public void query() {
        System.out.println(segmentTree);
        System.out.println(segmentTree.query(0, 3));
    }

    @Test
    public void setTest() {
        segmentTree.set(3, 14);
        System.out.println(segmentTree);
    }
}
