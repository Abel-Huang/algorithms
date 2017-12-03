package cn.abelib.other.unifind;

import java.util.Scanner;

/**
<<<<<<< HEAD
 * Created by abel-huang on 2017/1/19.
=======
 * Created by huangjinajin on 2017/1/19.
 * quick-find�㷨
>>>>>>> 245eb44931ba0001767e05c615c1e630842b2ec3
 * P140
 */
public class QF_UnionFind extends Basic_UnionFind {
    public QF_UnionFind(int N){
        count=N;
        id=new int[N];
        for (int i=0;i<N;i++){
            id[i]=i;
        }
    }

    public int  find(int q){
        return id[q];
    }

    public void union(int p, int q){
        int pID=find(p);
        int qID=find(q);
        if (pID==qID)
            return;
        for(int i=0;i<id.length;i++){
            if (find(i)==pID){
                id[i]=qID;
            }
        }
        count--;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input N");
        int N=sc.nextInt();
        QF_UnionFind uf=new QF_UnionFind(N);
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
