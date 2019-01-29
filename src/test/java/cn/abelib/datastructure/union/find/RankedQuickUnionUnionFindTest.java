package cn.abelib.datastructure.union.find;

import org.junit.Test;

/**
 * @Author: abel.huang
 * @Date: 2019-01-28 20:00
 */
public class RankedQuickUnionUnionFindTest {
    UnionFind unionFind = new RankedQuickUnionUnionFind(1000);

    @Test
    public void sizeTest() {
        System.out.println(unionFind.size());
    }

    @Test
    public void connectedTest() {
        System.out.println(unionFind.connected(0, 1));
        unionFind.union(0, 1);
        System.out.println(unionFind.connected(0, 1));
        System.out.println(unionFind.size());
    }
}
