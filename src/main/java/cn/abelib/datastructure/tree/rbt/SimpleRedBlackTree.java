package cn.abelib.datastructure.tree.rbt;


/**
 * @author abel-huang
 * @date 2018/4/2
 * 简单红黑树, 参考算法(4th)实现
 * 删除操作目前未完成
 */
public class SimpleRedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private TreeNode root;

    private class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;
        private int size;
        // true is read, false is black
        private boolean color;

        private TreeNode() {

        }

        private TreeNode(int value, int size, boolean color) {
            this.value = value;
            this.size = size;
            this.color = color;
        }
    }

    private boolean isRed(TreeNode treeNode) {
        if (treeNode == null) {
            return false;
        }
        return treeNode.color == RED;
    }

    /**
     * 左旋
     *
     * @param originalNode
     * @return
     */
    private TreeNode rotateLeft(TreeNode originalNode) {
        TreeNode subNode = originalNode.right;
        originalNode.right = subNode.left;
        subNode.left = originalNode;
        subNode.color = originalNode.color;
        originalNode.color = RED;
        subNode.size = originalNode.size;
        originalNode.size = 1 + size(originalNode.left) + size(originalNode.right);
        return subNode;
    }

    /**
     * 右旋
     *
     * @param originalNode
     * @return
     */
    private TreeNode rotateRight(TreeNode originalNode) {
        TreeNode subNode = originalNode.left;
        originalNode.left = subNode.right;
        subNode.right = originalNode;
        subNode.color = originalNode.color;
        originalNode.color = RED;
        subNode.size = originalNode.size;
        originalNode.size = 1 + size(originalNode.left) + size(originalNode.right);
        return subNode;
    }

    public int size() {
        return size(root);
    }

    private int size(TreeNode originalNode) {
        if (originalNode == null) {
            return 0;
        }
        return originalNode.size;
    }

    /**
     * @param node
     */
    private void flipColors(TreeNode node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public void insert(int value) {
        root = insert(root, value);
        root.color = BLACK;
    }

    /**
     * 红黑树的插入
     *
     * @param originalNode
     * @param value
     * @return
     */
    private TreeNode insert(TreeNode originalNode, int value) {
        if (originalNode == null) {
            return new TreeNode(value, 1, RED);
        }
        // 如果插入的值小于当前结点
        if (originalNode.value > value) {
            originalNode.left = insert(originalNode.left, value);
            // 如果插入的值大于当前结点
        } else if (originalNode.value < value) {
            originalNode.right = insert(originalNode.right, value);
        } else {
            originalNode.value = value;
        }

        // 当前结点的左孩子是黑色 右孩子是红色 当前结点需要进行左子树旋转
        if (isRed(originalNode.right) && !isRed(originalNode.left)) {
            originalNode = rotateLeft(originalNode);
        }
        // 当前结点的左孩子是红色 左孩子的左孩子是红色的 当前结点需要进行右子树旋转
        if (isRed(originalNode.left) && isRed(originalNode.left.left)) {
            originalNode = rotateRight(originalNode);
        }
        // 当前结点的左 右孩子都是红色 当前结点颜色需要 由红色变为黑色
        if (isRed(originalNode.right) && isRed(originalNode.left)) {
            flipColors(originalNode);
        }
        originalNode.size = size(originalNode.left) + size(originalNode.right) + 1;
        return originalNode;
    }

    /**
     * 遍历红黑树
     */
    public void visitTree() {
        inorderVisit(root);
    }

    private void inorderVisit(TreeNode originalNode) {
        if (originalNode == null) {
            return;
        }
        inorderVisit(originalNode.left);
        System.err.println(originalNode.value + "-->");
        inorderVisit(originalNode.right);
    }
}
