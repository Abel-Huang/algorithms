package cn.abelib.datastructure.unionfind;


/**
 * @author abel-huang
 * @date 2017/7/10
 * 加权quick-union算法
 */
public class WeightedQuickUnionUnionFind extends AbstractUnionFind {
    private int[] sz;

    public WeightedQuickUnionUnionFind(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    /**
     * @param p the old value
     * @return the new value
     */
    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    /**
     * @param p
     * @param q
     */
    @Override
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID)
            return;
        if (sz[pID] > sz[qID]) {
            id[qID] = pID;
            sz[pID] += sz[qID];
        } else {
            id[pID] = qID;
            sz[qID] += sz[pID];
        }
        count--;
    }
}
