package cn.abelib.datastructure.union.find;

/**
 * @author abel-huang
 * @date 2017/7/11
 * 路径压缩的加权quick-union算法
 * 通过调用find方法时，压缩树的深度，
 * 从而降低find的时间复杂度
 */
public class PathCompressionUnionFind extends RankedQuickUnionUnionFind {


    public PathCompressionUnionFind(int N) {
        super(N);
    }

    /**
     * 如果p不是根节点，就将p指向其父节点的父节点
     * @param p
     * @return
     */
    @Override
    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }
}
