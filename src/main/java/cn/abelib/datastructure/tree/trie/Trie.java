package cn.abelib.datastructure.tree.trie;

import cn.abelib.datastructure.map.HashMap;

/**
 * @Author: abel.huang
 * @Date: 2019-01-30 04:14
 */
public class Trie {
    private TrieNode root;
    private int size;

    class TrieNode{
        public boolean isWord;
        public HashMap<Character, TrieNode> next;

        public TrieNode(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public TrieNode() {
            this(false);
        }
    }

    public Trie() {
        root = new TrieNode();
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *  在 Trie 中添加字符串
     * @param word
     */
    public void add(String word) {
        if (word == null) {
            return;
        }
        TrieNode temp = root;
        for (int i =0; i < word.length(); i++) {
            if (temp.next.get(word.charAt(i)) == null){
                temp.next.put(word.charAt(i), new TrieNode());
            }
            temp = temp.next.get(word.charAt(i));
        }
        if (!temp.isWord) {
            temp.isWord = true;
            size++;
        }
    }

    /**
     *  在 Trie 中查询字符串是否存在
     * @param word
     * @return
     */
    public boolean contains(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            if (temp.next.get(word.charAt(i)) == null){
                return false;
            } else {
                temp = temp.next.get(word.charAt(i));
            }
        }
        return temp.isWord;
    }

    /**
     * 在 Trie 中查询字符串是否存在以
     * prefix 为前缀的字符串
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix){
        TrieNode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (temp.next.get(prefix.charAt(i)) == null){
                return false;
            } else {
                temp = temp.next.get(prefix.charAt(i));
            }
        }
        return true;
    }
}
