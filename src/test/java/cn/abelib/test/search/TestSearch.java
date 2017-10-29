package cn.abelib.test.search;

import cn.abelib.util.StdIO;
import cn.abelib.search.tree.BST;

public class TestSearch {
    public static void main(String [] args){
        BST<String, Integer> bst = new BST();
        StdIO.print(bst.size());
        bst.put("A", 1);
        StdIO.print(bst.size());
        bst.put("B", 2);
        StdIO.print(bst.size());
        bst.put("B", 2);
        StdIO.println(bst.size());
        Integer a = bst.get("A");
        StdIO.print(a);
        StdIO.print(bst.get("B"));
        for (String str : bst){
            StdIO.print(str);
        }
    }
}
