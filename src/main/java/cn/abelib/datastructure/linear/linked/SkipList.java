package cn.abelib.datastructure.linear.linked;

import cn.abelib.util.commons.RandomData;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abel-huang
 * @date 2017/12/25
 *  跳跃链表
 *  主要是参考Redis实现的SkipList
 *  todo
 */

public class SkipList<T>{
    private Node<T> head = new Node<>();
    private Node<T> tail = new Node<>();
    private int len;
    private int level;


    /**
     *  跳表节点
     * @param <T>
     */
    private class Node<T>{
        Node<T> backword;
        List<ListLevel> levels;
        double score;
        T value;

        //头结点专用
        Node(){
            int levelSize = RandomData.randLevel();
            levels = new ArrayList<>(levelSize);
        }

        public Node(Node<T> backword, List levels, double score, T value) {
            this.backword = backword;
            this.levels = levels;
            this.score = score;
            this.value = value;
        }
    }

    private class ListLevel<T>{
        // 前进指针
        Node<T> next;
        // 前进指针跨度
        int span;
    }

    public SkipList(){
        len = 0;
        level = 0;
    }

    public void add(T value){
        Node<T> node = new Node<>();
    }
}
