package com.abel.cp1.part2;

/**
 * Created by huangjianjin on 2017/1/19.
 */
public class UF {
    private int count;
    private int[] id;
    public UF(int N){
        id=new int[N];
        for (int i=0;i<N;i++){
            id[i]=i;
        }
        count=N;
    }

    public void find(){

    }

    public void union(){

    }

    public void count(){

    }

    public boolean connected(){
        return true;
    }
}
