package cn.abelib.datastructure.unionfind;

/**
 * @author abel-huang
 * @date 2017/1/19
 * quick-find
 */
public class QuickFindUnionFind extends AbstractUnionFind {
    public QuickFindUnionFind(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    @Override
    public int find(int q) {
        return id[q];
    }

    @Override
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (find(i) == pID) {
                id[i] = qID;
            }
        }
        count--;
    }
}
