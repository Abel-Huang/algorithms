package cn.abelib.datastructure.union.find;

/**
 * @Author: abel.huang
 * @Date: 2019-01-28 20:39
 */
public class RecursionPathCompressionUnionFind extends RankedQuickUnionUnionFind {
    public RecursionPathCompressionUnionFind(int N) {
        super(N);
    }

    /**
     * 基于递归，将所有的节点指向根节点,
     * 这次路径压缩是一次进行彻底压缩
     * @param p
     * @return
     */
    @Override
    public int find(int p) {
        if (p != id[p]) {
            id[p] = find(id[p]);
        }
        return id[p];
    }
}
