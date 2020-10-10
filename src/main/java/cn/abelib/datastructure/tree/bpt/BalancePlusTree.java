package cn.abelib.datastructure.tree.bpt;

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
     * 插入操作
     * @param entry
     */
    public void insert(KeyValue entry) {
        // 插入空B+树，此时根节点也为空
        if (this.root == null) {
            TreeNode node = new TreeNode();
            node.getKeyValues().add(entry);
            this.root = node;
            // 根节点没有父节点
            this.root.setParentNode(null);
        }
        // 只有一个非空节点的B+树，此时仅有一个节点即根节点
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

        // 分裂后的右边节点
        rightNode.setKeyValues(node.getKeyValues().subList(mid, node.getKeyValues().size()));
        rightNode.setParentNode(middleNode);

        // 分裂后的中间节点
        middleNode.getKeyValues().add(new KeyValue(node.getKeyValues().get(mid)));
        middleNode.getChildren().add(rightNode);

        // 分裂之前的原始节点, 即分裂后左边的部分
        //node.getKeyValues().subList(mid, node.getKeyValues().size()).clear();
        node.setKeyValues(node.getKeyValues().subList(0, mid));

        split(node.getParentNode(), node, middleNode, true);
    }

    /**
     *
     * @param curr 当前结点
     * @param prev 当前结点的子节点(实际上前驱节点)
     * @param insertingNode
     * @param first
     */
    private void split(TreeNode curr, TreeNode prev, TreeNode insertingNode, boolean first) {
        if (curr == null) {
            this.root = insertingNode;
            int indexForPrev = binarySearchInternalNode(prev.getKeyValues().get(0), insertingNode.getKeyValues());
            // 设置 insertingNode 父子节点关系
            prev.setParentNode(insertingNode);
            insertingNode.getChildren().add(indexForPrev, prev);
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
        else {
            merge(insertingNode, curr);
            // 如果合并后的节点已经满了
            if (curr.getKeyValues().size() == this.degree) {
                int mid = (int) (Math.ceil(this.degree / 2.0) - 1);
                TreeNode middleNode = new TreeNode();
                TreeNode rightNode = new TreeNode();

                // 分裂后的右边节点
                rightNode.setKeyValues(curr.getKeyValues().subList(mid + 1, curr.getKeyValues().size()));
                rightNode.setParentNode(middleNode);

                // 分裂后的中间节点
                middleNode.getKeyValues().add(curr.getKeyValues().get(mid));
                middleNode.getChildren().add(rightNode);

                List<TreeNode> childrenOfCurr = curr.getChildren();
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

                curr.getChildren().subList(lastChildOfLeft + 1, childrenOfCurr.size()).clear();
                curr.getKeyValues().subList(mid, curr.getKeyValues().size()).clear();

                split(curr.getParentNode(), curr, middleNode, false);
            }
        }
    }

    /**
     * 合并内部节点
     * @param mergeFrom
     * @param mergeInto
     */
    private void merge(TreeNode mergeFrom, TreeNode mergeInto) {
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

        //
        if (mergeInto.getChildren().isEmpty() && mergeInto.getChildren().get(0).getChildren().isEmpty()) {
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
        if (indexOfKey != 0 && node.getKeyValues().get(indexOfKey - 1).getKey().equals(entry.getKey())) {
            // 目前设计思路是key对应的value不是唯一的
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
            builder.append(curr.toString());
            if (curr.getChildren().isEmpty()) {
                break;
            }
            queue.addAll(curr.getChildren());

        }
        curr = curr.getNextNode();
        while (curr != null) {
            builder.append(curr.toString());
            curr = curr.getNextNode();
        }
        builder.append( '}');
        return builder.toString();
    }
}
