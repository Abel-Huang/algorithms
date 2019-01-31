package cn.abelib.datastructure.tree.trie;

import org.junit.Before;
import org.junit.Test;

/**
 * @Author: abel.huang
 * @Date: 2019-01-31 12:40
 */
public class TrieTest {
    private Trie trie;

    @Before
    public void init() {
        trie = new Trie();
    }

    @Test
    public void addTest() {
        trie.add("hello");
        trie.add("panda");
        trie.add("hi");
        trie.add("pen");
        System.out.println(trie.isEmpty());
        System.out.println(trie.size());
        System.out.println(trie.contains("hello"));
        System.out.println(trie.contains("hi"));
        System.out.println(trie.contains("pen"));
        System.out.println(trie.contains("pe"));
        System.out.println(trie.contains("pend"));
    }
}
