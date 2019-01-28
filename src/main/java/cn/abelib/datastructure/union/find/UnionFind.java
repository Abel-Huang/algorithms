package cn.abelib.datastructure.union.find;

/**
 * @Author: abel.huang
 * @Date: 2019-01-28 03:07
 */
public interface UnionFind {
    /**
     *  合并两个元素
     * @param p
     * @param q
     */
    void union(int p, int q);

    /**
     *  检查两个元素是否连接
     * @param p
     * @param q
     * @return
     */
    boolean connected(int p, int q);

    /**
     *  获取UF的元素个数
     * @return
     */
    int size();
}
