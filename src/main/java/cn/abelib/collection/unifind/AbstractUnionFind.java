package cn.abelib.collection.unifind;

/**
 * Created by abel-huang on 2017/7/12.
 */
public abstract  class AbstractUnionFind {
    protected int count;
    protected int[] id;
    public AbstractUnionFind(){}

    public abstract int  find(int q);

    public abstract void union(int p, int q);

    protected int count(){
        return count;
    }

    protected boolean connected(int p, int q){
        return find(p)==find(q);
    }
}
