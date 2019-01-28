package cn.abelib.datastructure.union.find;


/**
 * @author abel-huang
 * @date 2017/7/10
 * 加权quick-union算法，基于size进行优化
 * size是指向父节点的孩子的数量, size[i]
 * 表示根节点为i的树的孩子数量
 */
public class SizedQuickUnionUnionFind extends AbstractUnionFind {
    protected int[] sz;

    public SizedQuickUnionUnionFind(int N) {
        size = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    /**
     * @param p
     * @return
     */
    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    /**
     * 通过size数组，可以保证树的深度会比较小(并不一定)
     * @param p
     * @param q
     */
    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (sz[pRoot] > sz[qRoot]) {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        } else {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        size--;
    }
}
