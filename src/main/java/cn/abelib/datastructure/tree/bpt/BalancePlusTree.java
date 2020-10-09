package cn.abelib.datastructure.tree.bpt;

import java.util.List;

/**
 * @author abel-huang
 * @date 2017/11/2
 * B+树的简单实现
 */
public class BalancePlusTree {
    /**
     * 根节点
     */
    private TreeNode root;
    /**
     * B+树阶数
     */
    private int degree;

    public BalancePlusTree(int degree) {
        this.degree = degree;
        this.root = null;
    }

    public TreeNode getRoot() {
        return this.root;
    }

    /**
     * 插入操作
     * @param entry
     */
    public void insert(KeyValue entry) {
        List<KeyValue> keyValues;
        // 插入空B+树
        if (this.root == null) {
            TreeNode node = new TreeNode();
            node.getKeyValues().add(entry);
            this.root = node;
            // 根节点没有父节点
            this.root.setParentNode(null);
        }
        // 只有一个非空节点的B+树
        else if (this.root.getChildren().isEmpty() && this.root.getKeyValues().size() < (this.degree - 1)) {
            insert(entry, this.root);
        }
        // 常规场景
        else {
            TreeNode curr = this.root;
            while (!curr.getChildren().isEmpty()) {
                curr = curr.getChildren().get(binarySearchInternalNode(entry, curr.getKeyValues()));
            }
            insert(entry, curr);
            if (curr.getKeyValues().size() == this.degree) {
                split(curr, this.degree);
            }
        }
    }

    // todo
    private void split(TreeNode curr, int degree) {

    }

    private void insert(KeyValue entry, TreeNode node) {
        int indexOfKey = binarySearchInternalNode(entry, node.getKeyValues());
        if (indexOfKey != 0 && node.getKeyValues().get(indexOfKey - 1).getKey().equals(entry.getKey())) {
            // 目前设计思路是key对应的value不是唯一的
            node.getKeyValues().get(indexOfKey - 1).getValues().addAll(entry.getValues());
        } else {
            node.getKeyValues().add(indexOfKey - 1, entry);
        }
    }

    /**
     * 找到keyValues中比entry小的第一个元素
     * @param entry
     * @param keyValues
     * @return
     */
    public int binarySearchInternalNode(KeyValue entry, List<KeyValue> keyValues) {
        int left = 0;
        int right = keyValues.size() - 1;
        int mid;
        int index = -1;
        // 如果小于第一个元素，那位置就在第一个位置
        if (entry.compareTo(keyValues.get(left)) < 0) {
            return 0;
        }
        // 如果大于最后一个元素，那位置就在集合最后一个位置
        if (entry.compareTo(keyValues.get(right)) >= 0) {
            return keyValues.size();
        }
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (entry.compareTo(keyValues.get(mid)) < 0 && entry.compareTo(keyValues.get(mid - 1)) >= 0) {
                index = mid;
                break;
            } else if (entry.compareTo(keyValues.get(mid)) >= 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    /**
     * 搜索操作
     * @param key
     * @return
     */
    public Object search(String key) {
        return null;
    }

    /**
     * 删除操作
     * @param key
     * @return
     */
    public boolean delete(String key) {
        return false;
    }
}
