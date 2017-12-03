package cn.abelib.other.unifind;

import java.util.Scanner;

/**
<<<<<<< HEAD
 * Created by abel-huang on 2017/7/10.
=======
 * Created by huangjinajin on 2017/7/10.
 * ��Ȩ��quick-union�㷨
 * ͨ������һ�������¼ÿ��component�Ĵ�С�����ǽ�С�ļӵ��������
>>>>>>> 245eb44931ba0001767e05c615c1e630842b2ec3
 * p144
 */
public class QUW_UnionFind extends Basic_UnionFind {
    private int[] sz;
    public QUW_UnionFind(int N){
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
        while(p!=id[p])
            p=id[p];
        return p;
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
        QUW_UnionFind uf=new QUW_UnionFind(N);
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
