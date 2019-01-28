package cn.abelib.datastructure.unionfind;

import cn.abelib.datastructure.union.find.QuickUnionUnionFind;
import cn.abelib.datastructure.union.find.UnionFind;
import org.junit.Test;

/**
 * Created by abel-huang on 2017/7/24.
 */
public class QuickUnionUnionFindTest {
    UnionFind unionFind = new QuickUnionUnionFind(1000);

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
