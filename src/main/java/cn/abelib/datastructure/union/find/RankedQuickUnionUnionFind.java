package cn.abelib.datastructure.union.find;

/**
 * @Author: abel.huang
 * @Date: 2019-01-28 19:46
 * 基于rank的优化算法，
 * rank是指向父节点的孩子的深度，rank[i]
 * 表示根节点为i的树的高度
 */
public class RankedQuickUnionUnionFind extends AbstractUnionFind{
    protected int[] rk;

    public RankedQuickUnionUnionFind(int N) {
        size = N;
        id = new int[N];
        rk = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            rk[i] = 1;
        }
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    /**
     * 通过rank数组，保证树的深度
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
        if (rk[pRoot] > rk[qRoot]) {
            id[qRoot] = pRoot;
        } else if (rk[pRoot] < rk[qRoot]){
            id[pRoot] = qRoot;
        } else {
            id[pRoot] = qRoot;
            rk[qRoot] += 1;
        }
        size--;
    }
}
