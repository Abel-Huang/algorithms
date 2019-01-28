package cn.abelib.datastructure.union.find;

/**
 * @author abel-huang
 * @date 2017/7/12
 */
public abstract class AbstractUnionFind implements UnionFind{
    protected int size;
    protected int[] id;

    public AbstractUnionFind() {
    }

    public abstract int find(int q);

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
