package cn.abelib.algorithm.unionfind;

import java.util.Scanner;

/**
 *
 * @author abel-huang
 * @date 2017/7/11
 * 路径压缩的加权quick-union算法
 */
public class PathCompressionUnionFind extends AbstractUnionFind {
    private int[] sz;
    public PathCompressionUnionFind(int N){
        count=N;
        id=new int[N];
        sz=new int[N];
        for(int i=0;i<N;i++){
            id[i]=i;
            sz[i]=1;
        }
    }

    /**
     * @param p the old value
     * @return the new value
     */
    public int find(int p){
        int root=p;
        // �ҵ����ڵ�
        while(root!=id[root]){
            root=id[root];
        }
        /**
         * �ڽ�pָ����ڵ�Ĺ����н���
         * ���м�ĵ�Ҳ��ָ��root�ڵ�
         */
        while(p!=root){
            int x=p;
            id[x]=root;
            p=id[p];
        }
        return root;
    }

    /**
     * @param p
     * @param q
     */
    public void union(int p, int q){
        int pID=find(p);
        int qID=find(q);
        if(pID==qID)
            return;
        if (sz[pID]>sz[qID]){
            id[qID]=pID;
            sz[pID]+=sz[qID];
        }else{
            id[pID]=qID;
            sz[qID]+=sz[pID];
        }
        count--;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input N");
        int N=sc.nextInt();
        PathCompressionUnionFind uf=new PathCompressionUnionFind(N);
        System.out.println("Input M");
        int M=sc.nextInt();
        for(int i=0;i<M;i++){
            System.out.println("Input two integer");
            int p=sc.nextInt();
            int q=sc.nextInt();
            if(uf.connected(p,q))
                continue;
            uf.union(p,q);
            System.out.println(p+" : "+q);
        }
        System.out.println(uf.count()+" component");
    }
}
