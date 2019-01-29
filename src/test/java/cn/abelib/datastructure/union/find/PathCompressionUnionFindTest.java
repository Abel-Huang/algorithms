package cn.abelib.datastructure.union.find;

import org.junit.Test;

/**
 * Created by abel-huang on 2017/7/24.
 */
public class PathCompressionUnionFindTest {
    UnionFind unionFind = new PathCompressionUnionFind(1000);

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

