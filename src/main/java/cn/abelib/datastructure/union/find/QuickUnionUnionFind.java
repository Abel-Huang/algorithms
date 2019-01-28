package cn.abelib.datastructure.union.find;

/**
 * @author abel-huang
 * @date 2017/7/10
 * quick-union
 * 通过数组来表示树，数组的索引表示孩子，数组的值表示对应的父节点的索引
 * 即这棵树是由子节点指向父节点的，如果该节点索引和值相同，则该节点是
 * 父节点，相同父节点表示是连接的，开始时节点不相连表示的是一个森林
 * p141
 */
public class QuickUnionUnionFind extends AbstractUnionFind {
    public QuickUnionUnionFind(int N) {
        size = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     *  找到父节点，并返回父节点的值
     * @param q
     * @return
     */
    @Override
    public int find(int q) {
        while (q != id[q]) {
            q = id[q];
        }
        return q;
    }

    /**
     *  使得二者的根节点相同
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
        id[pRoot] = qRoot;
        size--;
    }
}
