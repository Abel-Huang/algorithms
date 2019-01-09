package cn.abelib.algorithm.unionfind;

import java.util.Scanner;

/**
 * @author abel-huang
 * @date 2017/7/10
 * quick-union
 * p141
 */
public class QuickUnionUnionFind extends AbstractUnionFind {
    public QuickUnionUnionFind(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int find(int q) {
        while (q != id[q])
            q = id[q];
        return q;
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID)
            return;
        id[pID] = qID;
        count--;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input N");
        int N = sc.nextInt();
        QuickUnionUnionFind uf = new QuickUnionUnionFind(N);
        System.out.println("Input M");
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            System.out.println("Input two integer");
            int p = sc.nextInt();
            int q = sc.nextInt();
            if (uf.connected(p, q))
                continue;
            uf.union(p, q);
            System.out.println(p + " : " + q);
        }
        System.out.println(uf.count() + " component");
    }
}
