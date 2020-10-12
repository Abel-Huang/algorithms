package cn.abelib.datastructure.tree.bpt;

import cn.abelib.util.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
     * 插入操作 todo 对于isLeaf的属性修改存在问题
     * @param entry
     */
    public void insert(KeyValue entry) {
        // 插入空B+树，此时根节点也为空
        if (this.root == null) {
            this.root = new TreeNode();
            this.root.getKeyValues().add(entry);
            // 根节点没有父节点
            this.root.setParentNode(null);
            // 只有一个根节点，此时没有索引节点，只有根节点
            this.root.setLeaf(true);
        }
        // 只有一个非空节点的B+树，此时仅有一个节点即根节点，且未达到分裂阈值
        else if (this.root.getChildren().isEmpty() && this.root.getKeyValues().size() < (this.degree - 1)) {
            insert(entry, this.root);
        }
        // 常规场景，此时需要考虑节点分裂情况
        else {
            TreeNode curr = this.root;
            // 通过判断在索引节点的哪个位置来确定位于子节点的位置
            while (!curr.getChildren().isEmpty()) {
                curr = curr.getChildren().get(binarySearchInternalNode(entry, curr.getKeyValues()));
            }
            insert(entry, curr);
            // 如果超过阈值需要进行节点分裂
            if (curr.getKeyValues().size() == this.degree) {
                split(curr);
            }
        }
    }

    /**
     * 进行节点的分裂
     * @param node
     */
    private void split(TreeNode node) {
        int mid = this.degree / 2;
        TreeNode middleNode = new TreeNode();
        TreeNode rightNode = new TreeNode();

        // 分裂后的右边节点, 即后续的右边子节点
        List<KeyValue> keyValues = (List<KeyValue>) CollectionUtils.subList(node.getKeyValues(), mid, node.getKeyValues().size());
        rightNode.setKeyValues(keyValues);
        rightNode.setParentNode(middleNode);

        // 分裂后的中间节点, 即后续的父节点
        middleNode.getKeyValues().add(node.getKeyValues().get(mid));
        middleNode.getChildren().add(rightNode);

        // 分裂之前的原始节点, 即分裂后左边子节点
        node.setKeyValues((List<KeyValue>) CollectionUtils.subList(node.getKeyValues(),0, mid));

        split(node, middleNode, true);
    }

    /**
     *
     * @param left
     * @param insertingNode
     * @param first
     */
    private void split(TreeNode left, TreeNode insertingNode, boolean first) {
        TreeNode parent = left.getParentNode();
        // 说明当前结点的父节点为空，即当前结点为根节点
        if (parent == null) {
            this.root = insertingNode;
            int indexForPrev = binarySearchInternalNode(left.getKeyValues().get(0), insertingNode.getKeyValues());
            // 设置 insertingNode 父子节点关系
            left.setParentNode(insertingNode);
            insertingNode.getChildren().add(indexForPrev, left);
            if (first) {
                if (indexForPrev == 0) {
                    insertingNode.getChildren().get(0).setNextNode(insertingNode.getChildren().get(1));
                    insertingNode.getChildren().get(1).setPrevNode(insertingNode.getChildren().get(0));
                } else {
                    insertingNode.getChildren().get(indexForPrev - 1).setNextNode(insertingNode.getChildren().get(indexForPrev));
                    insertingNode.getChildren().get(indexForPrev + 1).setPrevNode(insertingNode.getChildren().get(indexForPrev));
                }
            }
        }
        // 当前需要分裂的节点不是根节点
        else {
            promote(insertingNode, parent);
            // 判断父节点是否需要进行分裂
            if (parent.getKeyValues().size() == this.degree) {
                int mid = (int) (Math.ceil(this.degree / 2.0) - 1);
                TreeNode middleNode = new TreeNode();
                TreeNode rightNode = new TreeNode();

                // 分裂后的右边节点
                rightNode.setKeyValues(parent.getKeyValues().subList(mid + 1, parent.getKeyValues().size()));
                rightNode.setParentNode(middleNode);

                // 分裂后的中间节点
                middleNode.getKeyValues().add(parent.getKeyValues().get(mid));
                middleNode.getChildren().add(rightNode);

                List<TreeNode> childrenOfCurr = parent.getChildren();
                List<TreeNode> childrenOfRight = new ArrayList<>();
                int lastChildOfLeft = childrenOfCurr.size() - 1;

                for (int i = childrenOfCurr.size() - 1; i >= 0; i --) {
                    List<KeyValue> keyValues = childrenOfCurr.get(i).getKeyValues();
                    if (middleNode.getKeyValues().get(0).compareTo(keyValues.get(0)) <= 0) {
                        childrenOfCurr.get(i).setParentNode(rightNode);
                        childrenOfRight.add(0, childrenOfCurr.get(i));
                        lastChildOfLeft --;
                    } else {
                        break;
                    }

                }
                rightNode.setChildren(childrenOfRight);

                parent.getChildren().subList(lastChildOfLeft + 1, childrenOfCurr.size()).clear();
                parent.getKeyValues().subList(mid, parent.getKeyValues().size()).clear();

                split(parent, middleNode, false);
            }
        }
    }

    /**
     * 合并内部节点，如果非根节点超出阈值，需要分裂并且将中间数据节点晋升到父索引节点
     * @param mergeFrom
     * @param mergeInto
     */
    private void promote(TreeNode mergeFrom, TreeNode mergeInto) {
        KeyValue keyValue = mergeFrom.getKeyValues().get(0);
        TreeNode childNode = mergeFrom.getChildren().get(0);

        int index = binarySearchInternalNode(keyValue, mergeInto.getKeyValues());
        int childIndex = index;
        if (keyValue.compareTo(childNode.getKeyValues().get(0)) <= 0) {
            childIndex = index + 1;
        }

        childNode.setParentNode(mergeInto);
        mergeInto.getChildren().add(childIndex, childNode);
        mergeInto.getKeyValues().add(index, keyValue);

        // 设置新节点的前驱后继关系
        if (!mergeInto.getChildren().isEmpty() && mergeInto.getChildren().get(0).getChildren().isEmpty()) {
            if (mergeInto.getChildren().size() - 1 != childIndex && mergeInto.getChildren().get(childIndex + 1).getPrevNode() == null) {
                mergeInto.getChildren().get(childIndex + 1).setPrevNode(mergeInto.getChildren().get(childIndex));
                mergeInto.getChildren().get(childIndex).setNextNode(mergeInto.getChildren().get(childIndex + 1));
            }

            else if (childIndex != 0 && mergeInto.getChildren().get(childIndex - 1).getNextNode() == null) {
                mergeInto.getChildren().get(childIndex).setPrevNode(mergeInto.getChildren().get(childIndex - 1));
                mergeInto.getChildren().get(childIndex - 1).setNextNode(mergeInto.getChildren().get(childIndex));
            }

            else {
                mergeInto.getChildren().get(childIndex).setNextNode(mergeInto.getChildren().get(childIndex - 1).getNextNode());
                mergeInto.getChildren().get(childIndex).getNextNode().setPrevNode(mergeInto.getChildren().get(childIndex));

                mergeInto.getChildren().get(childIndex - 1).setNextNode(mergeInto.getChildren().get(childIndex));
                mergeInto.getChildren().get(childIndex).setPrevNode(mergeInto.getChildren().get(childIndex - 1));
            }
        }
    }

    private void insert(KeyValue entry, TreeNode node) {
        int indexOfKey = binarySearchInternalNode(entry, node.getKeyValues());
        //如果是同样的key，则插入到同一个kv中, 目前设计思路是key对应的value不是唯一的, 可以为多个，后续应该可以改为设置是否支持unique
        if (indexOfKey != 0 && node.getKeyValues().get(indexOfKey - 1).getKey().equals(entry.getKey())) {
            node.getKeyValues().get(indexOfKey - 1).getValues().addAll(entry.getValues());
        } else {
            node.getKeyValues().add(indexOfKey, entry);
        }
    }

    /**
     * 按照keyValues从小到大的顺序，找到entry所处的位置
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

    @Override
    public String toString() {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder("BalancePlusTree{" +
                "root=" + root +
                ", degree=" + degree +
                ", ");
        queue.add(this.root);
        TreeNode curr = null;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            if (curr == null) {
                if (queue.peek() == null) {
                    break;
                }
                continue;
            }
            builder.append(printNode(curr));
            if (curr.getChildren().isEmpty()) {
                break;
            }
            queue.addAll(curr.getChildren());

        }
        curr = curr.getNextNode();
        while (curr != null) {
            builder.append(printNode(curr));
            curr = curr.getNextNode();
        }
        builder.append('}');
        return builder.toString();
    }

    private String printNode(TreeNode curr) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < curr.getKeyValues().size(); i++) {
            builder.append(curr.getKeyValues().get(i).getKey()).append(":(");
            String values = "";
            for (int j = 0; j < curr.getKeyValues().get(i).getValues().size(); j++) {
                builder.append(curr.getKeyValues().get(i).getValues().get(j)).append(",");
            }
            builder.append(values.isEmpty() ? ");" : values.substring(0, values.length() - 1)).append(");");
        }
        builder.append("||");
        return builder.toString();
    }

    public List<TreeNode> toList() {
        return preorder(this.root);
    }

    private List<TreeNode> preorder(TreeNode node) {
        List<TreeNode> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        result.add(node);
        for (TreeNode curr : node.getChildren()) {
            result.addAll(preorder(curr));
        }
        return result;
    }
}
