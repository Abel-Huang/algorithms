package cn.abelib.other.unifind;

/**
<<<<<<< HEAD
 * Created by abel-huang on 2017/7/12.
=======
 * Created by huangjianjin on 2017/7/12.
>>>>>>> 245eb44931ba0001767e05c615c1e630842b2ec3
 */
public abstract  class Basic_UnionFind {
    protected int count;
    protected int[] id;
    public Basic_UnionFind(){}

    public abstract int  find(int q);

    public abstract void union(int p, int q);

    protected int count(){
        return count;
    }

    protected boolean connected(int p, int q){
        return find(p)==find(q);
    }
}
