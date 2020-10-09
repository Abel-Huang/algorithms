package cn.abelib.datastructure.tree.bst;

import cn.abelib.datastructure.linear.Collection;
import cn.abelib.datastructure.linear.queue.Queue;
import cn.abelib.datastructure.linear.stack.Stack;
import cn.abelib.datastructure.linear.list.LinkedList;
import cn.abelib.datastructure.linear.queue.LinkedQueue;
import cn.abelib.datastructure.linear.stack.LinkedStack;
import cn.abelib.util.annotation.UnFinish;

import java.util.Iterator;

/**
 * 基础的二叉树
 *
 * @author abel-huang
 * @date 17/10/30
 */
public class BinaryTree<T extends Comparable<T>> implements Collection<T> {
    private TreeNode root;
    protected int size;

    private class TreeNode {
        private T value;
        private TreeNode left;
        private TreeNode right;

        private TreeNode(T value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public BinaryTree() {
        root = null;
        size = 0;
    }

    /**
     * tree size
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * tree is empty or not
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 批量插入
     *
     * @param items
     */
    public void add(Collection<T> items) {
        if (items == null || items.size() == 0) {
            return;
        }
        for (T item : items) {
            add(item);
        }
    }

    /**
     * 非递归插入
     *
     * @param item
     */
    public void add(T item) {
        if (root == null) {
            root = new TreeNode(item);
            size++;
            return;
        }
        TreeNode current = root;
        if (contains(item)) {
            return;
        }
        while (current != null) {
            if (current.value.compareTo(item) > 0) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new TreeNode(item);
                    size++;
                    break;
                }
            } else if (current.value.compareTo(item) < 0) {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new TreeNode(item);
                    size++;
                    break;
                }
            }
        }
    }

    /**
     * 递归插入
     *
     * @param item
     */
    public void addRecursion(T item) {
        if (contains(item)) {
            return;
        }
        root = addRecursion(root, item);
    }

    /**
     * @param node
     * @param item
     * @return
     */
    private TreeNode addRecursion(TreeNode node, T item) {
        if (node == null) {
            size++;
            return new TreeNode(item);
        }
        // 如果插入的值小于当前结点
        if (node.value.compareTo(item) > 0) {
            node.left = addRecursion(node.left, item);
            // 如果插入的值大于当前结点
        } else if (node.value.compareTo(item) < 0) {
            node.right = addRecursion(node.right, item);
        }
        return node;
    }

    /**
     * 查看是否包含元素value
     *
     * @param item
     * @return
     */
    public boolean contains(T item) {
        return contains(root, item);
    }

    private boolean contains(TreeNode node, T item) {
        if (node == null) {
            return false;
        }
        if (node.value.compareTo(item) > 0) {
            return contains(node.left, item);
        } else if (node.value.compareTo(item) == 0) {
            return true;
        } else {
            return contains(node.right, item);
        }
    }

    /**
     * 找到二叉树最大值
     *
     * @return
     */
    public T max() {
        if (size < 1) {
            return null;
        }
        if (size == 1) {
            return root.value;
        }
        TreeNode traveses = root;
        while (traveses.right != null) {
            traveses = traveses.right;
        }
        return traveses.value;
    }

    /**
     * 删除最大元素
     *
     * @return
     */
    public T removeMax() {
        T item = max();
        root = removeMax(root);
        return item;
    }

    /**
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private TreeNode removeMax(TreeNode node) {
        if (node.right == null) {
            TreeNode traveses = node.left;
            node.left = null;
            size--;
            return traveses;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 找到二叉树最小值
     *
     * @return
     */
    public T min() {
        if (size < 1) {
            return null;
        }
        if (size == 1) {
            return root.value;
        }
        TreeNode traveses = root;
        while (traveses.left != null) {
            traveses = traveses.left;
        }
        return traveses.value;
    }

    /**
     * 删除最小元素
     *
     * @return
     */
    public T removeMin() {
        T item = min();
        root = removeMin(root);
        return item;
    }

    /**
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) {
            TreeNode rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @UnFinish
    public boolean remove(T item) {
        // todo
        return false;
    }

    /**
     *  惰性删除
     * @param item
     * @return
     */
    @UnFinish
    public boolean lazyRemove(T item) {
        // todo
        return false;
    }

    /**
     * 非递归广度优先遍历
     *
     * @return
     */

    public LinkedList<T> levelOrderVisit() {
        return levelOrderVisit(root);
    }

    private LinkedList<T> levelOrderVisit(TreeNode originalNode) {
        LinkedList<T> nodes = new LinkedList<>();
        if (size < 1) {
            return nodes;
        }
        TreeNode traveses = originalNode;
        Queue<TreeNode> queue = new LinkedQueue<>();
        queue.enqueue(traveses);
        while (!queue.isEmpty()) {
            traveses = queue.dequeue();
            nodes.add(traveses.value);
            if (traveses.left != null) {
                queue.enqueue(traveses.left);
            }
            if (traveses.right != null) {
                queue.enqueue(traveses.right);
            }
        }
        return nodes;
    }

    public LinkedList<T> inOrderVisitRecursion() {
        LinkedList<T> nodes = new LinkedList<>();
        inOrderVisitRecursion(root, nodes);
        return nodes;
    }

    /**
     * 递归中序遍历
     *
     * @param originalNode
     */
    private void inOrderVisitRecursion(TreeNode originalNode, LinkedList<T> nodes) {
        if (originalNode == null) {
            return;
        }
        inOrderVisitRecursion(originalNode.left, nodes);
        nodes.add(originalNode.value);
        inOrderVisitRecursion(originalNode.right, nodes);
    }

    public LinkedList<T> inOrderVisit() {
        return inOrderVisit(root);
    }

    /**
     * 非递归中序遍历
     *
     * @param originalNode
     */
    @UnFinish
    private LinkedList<T> inOrderVisit(TreeNode originalNode) {
        // todo
        LinkedList<T> nodes = new LinkedList<>();
        if (size < 1) {
            return nodes;
        }
        TreeNode traveses = originalNode;
        Stack<TreeNode> stack = new LinkedStack<>();
        stack.push(traveses);
        while (!stack.isEmpty()) {
            if (traveses.left != null) {
                stack.push(traveses.left);
                traveses = traveses.left;
            } else {
                traveses = stack.pop();
                nodes.add(traveses.value);
                if (traveses.right != null) {
                    stack.push(traveses.right);
                }

            }
        }
        return nodes;
    }

    public LinkedList<T> preOrderVisitRecursion() {
        LinkedList<T> nodes = new LinkedList<>();
        preOrderVisitRecursion(root, nodes);
        return nodes;
    }

    /**
     * 递归前序遍历
     *
     * @param originalNode
     * @param nodes
     */
    private void preOrderVisitRecursion(TreeNode originalNode, LinkedList<T> nodes) {
        if (originalNode == null) {
            return;
        }
        nodes.add(originalNode.value);
        preOrderVisitRecursion(originalNode.left, nodes);
        preOrderVisitRecursion(originalNode.right, nodes);
    }

    public LinkedList<T> preOrderVisit() {
        return preOrderVisit(root);
    }

    /**
     * 非递归前序遍历
     *
     * @param originalNode
     */
    private LinkedList<T> preOrderVisit(TreeNode originalNode) {
        LinkedList<T> nodes = new LinkedList<>();
        if (size < 1) {
            return nodes;
        }
        TreeNode traveses = originalNode;
        Stack<TreeNode> stack = new LinkedStack<>();
        stack.push(traveses);
        while (!stack.isEmpty()) {
            traveses = stack.pop();
            nodes.add(traveses.value);
            if (traveses.right != null) {
                stack.push(traveses.right);
            }
            if (traveses.left != null) {
                stack.push(traveses.left);
            }
        }
        return nodes;
    }

    public LinkedList<T> postOrderVisitRecursion() {
        LinkedList<T> nodes = new LinkedList<>();
        postOrderVisitRecursion(root, nodes);
        return nodes;
    }

    /**
     * 递归后序遍历
     *
     * @param originalNode
     */
    private void postOrderVisitRecursion(TreeNode originalNode, LinkedList<T> nodes) {
        if (originalNode == null) {
            return;
        }
        postOrderVisitRecursion(originalNode.left, nodes);
        postOrderVisitRecursion(originalNode.right, nodes);
        nodes.add(originalNode.value);
    }

    public LinkedList<T> postOrderVisit() {
        LinkedList<T> nodes = new LinkedList<>();
        postOrderVisit(root, nodes);
        return nodes;
    }

    /**
     * 非递归后序遍历
     *
     * @param originalNode
     */
    private void postOrderVisit(TreeNode originalNode, LinkedList<T> nodes) {
        // todo
    }


    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        private int i = 0;
        private LinkedList<T> nodes = inOrderVisitRecursion();

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public T next() {
            return nodes.get(i++);
        }

        @Override
        public void remove() {
        }
    }

    @Override
    public String toString() {
        // todo
        return super.toString();
    }
}
