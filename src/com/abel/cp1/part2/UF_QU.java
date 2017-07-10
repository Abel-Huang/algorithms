package com.abel.cp1.part2;

import java.util.Scanner;

/**
 * Created by huangjinajin on 2017/7/10.
 * quick-unionËã·¨
 * p141
 */
public class UF_QU {
    private int count;
    private int[] id;
    public UF_QU(int N){
        count=N;
        id=new int[N];
        for (int i=0;i<N;i++){
            id[i]=i;
        }
    }

    public int  find(int q){
        while(q!=id[q])
            q=id[q];
        return q;
    }

    public void union(int p, int q){
        int pID=find(p);
        int qID=find(q);
        if (pID==qID)
            return;
        id[pID]=qID;
        count--;
    }

    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p)==find(q);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input N");
        int N=sc.nextInt();
        UF_QU uf=new UF_QU(N);
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
