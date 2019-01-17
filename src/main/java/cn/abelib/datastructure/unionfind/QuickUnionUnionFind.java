package cn.abelib.datastructure.unionfind;

/**
 * @author abel-huang
 * @date 2017/7/10
 * quick-union
 * p141
 */
public class QuickUnionUnionFind extends AbstractUnionFind {
    public QuickUnionUnionFind(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    @Override
    public int find(int q) {
        while (q != id[q]) {
            q = id[q];
        }
        return q;
    }

    @Override
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) {
            return;
        }
        id[pID] = qID;
        count--;
    }
}
