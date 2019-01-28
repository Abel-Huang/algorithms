package cn.abelib.datastructure.union.find;

/**
 * @author abel-huang
 * @date 2017/1/19
 * quick-find, 快速查找，基于数组
 * 索引表示节点，如果两个索引对应的值相同，那么两个
 * 节点是处于连接状态的
 */
public class QuickFindUnionFind extends AbstractUnionFind {
    public QuickFindUnionFind(int N) {
        size = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * O(1)
     * @param q
     * @return
     */
    @Override
    public int find(int q) {
        return id[q];
    }

    /**
     * o(N)
     * @param p
     * @param q
     */
    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
        size--;
    }
}
