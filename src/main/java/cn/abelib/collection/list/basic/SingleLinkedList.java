package cn.abelib.collection.list.basic;

/**
 * Created by abel-huang on 17/10/30.
 *  基础的单向链表，每个节点有一个指向后继元素的next指针
 */
public class SingleLinkedList {
    /**
     *  链表的节点
     */
    public class ListNode{
        private int data;
        private ListNode next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public ListNode(int data){
            this.data = data;
        }
    }

    /**
     *  获得链表的长度
     * @param headNode
     * @return
     */
    public int listLength(ListNode headNode){
        int length = 0;
        ListNode currentNode = headNode;
        while (currentNode.getNext() != null){
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    /**
     *  头插
     */
    public ListNode insertHead(ListNode insertNode, ListNode headNode){
        if (insertNode == null || headNode == null){
            return headNode;
        }
        insertNode.setNext(headNode);
        return insertNode;
    }

    /**
     *  尾插
     */
    public ListNode insertTail(ListNode insertNode, ListNode headNode){
        if (insertNode == null || headNode == null){
            return headNode;
        }
        ListNode currentNode = headNode;
        while (currentNode.getNext() != null){
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(insertNode);
        return headNode;
    }

    /**
     *  插入 position 从0开始计算
     * @param insertNode
     * @param headNode
     * @param position
     * @return
     */
    public ListNode insert(ListNode insertNode, ListNode headNode, int position){
        if (insertNode == null || headNode == null){
            return headNode;
        }
        int size = this.listLength(headNode);
        if (position < 0 || position > size - 1){
            return headNode;
        }
        if (position == 0){
            return this.insertHead(insertNode, headNode);
        }
        if (position == size-1){
            return this.insertTail(insertNode, headNode);
        }
        ListNode currentNode = headNode;
        int index = 1;
        while (index != position){
            index++;
            currentNode = currentNode.getNext();
        }
        ListNode nextNode = currentNode.getNext();
        currentNode.setNext(insertNode);
        insertNode.setNext(nextNode);
        return headNode;
    }
//
//    public ListNode deleteHead(ListNode headNode){
//        if (insertNode == null || headNode == null){
//            return headNode;
//        }
//
//    }
//
//    public ListNode deleteTail(ListNode insertNode, ListNode headNode){
//        if (insertNode == null || headNode == null){
//            return headNode;
//        }
//    }
//
//    public ListNode delete(ListNode insertNode, ListNode headNode, int position){
//        if (insertNode == null || headNode == null){
//            return headNode;
//        }
//    }
}
