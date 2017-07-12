package com.abel.basic.unifind;

/**
 * Created by huangjianjin on 2017/7/12.
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
