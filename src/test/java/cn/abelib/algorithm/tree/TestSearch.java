package cn.abelib.algorithm.tree;

import cn.abelib.common.StdIO;
import cn.abelib.utils.search.tree.BST;
import org.junit.Test;

public class TestSearch {
    @Test
    public  void searchTest(){
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
