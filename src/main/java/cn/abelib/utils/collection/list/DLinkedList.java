package cn.abelib.utils.collection.list;

/**
 * Created by ${abel-huang} on 18/2/28.
 */
// 模仿Redis底层双向链表的实现，是Redis list的底层实现之一, 部分参考了Java LinkedList

public class DLinkedList<T> {
    private Node<T> tail = new Node<>();
    private Node<T> head = new Node<>();
    private int len;

    private class Node<T>{
        Node<T> prev;
        Node<T> next;
        T value;

        Node(){

        }

        Node(T value){
            this.value = value;
        }

        Node(T value,   Node<T> prev,   Node<T> next){
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public DLinkedList(){
        len = 0;
    }

    /**
     *  add tail
     * @param value
     * @return
     */
    public boolean add(T value){
        Node<T> now = new Node<>(value);
        if (len == 0){
            len++;
            head.next = now;
            tail.next = now;
            return true;
        }
        Node<T> pre = tail.next;
        pre.next = now;
        now.prev = pre;
        tail.next = now;
        len++;
        return true;
    }

    /**
     * add DLinkedList
     * @param list
     * @return
     */
    public boolean add(DLinkedList<T> list){
        for (int i= 0; i< list.len; i++)
            this.add(list.get(i));
        return true;
    }

    /**
     * return list length
     * @return
     */
    public int len(){
        return this.len;
    }

    /**
     * return the item of index
     * @param index
     * @return
     */
    public T get(int index){
        if (index < 0 || index >= len){
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        Node<T> tmp = head;
        for (int i = 0; i <= index; ++i){
            tmp = tmp.next;
        }
        return tmp.value;
    }

    /**
     * return the index of the first same value
     * @param value
     * @return
     */
    public int index(T value){
        if (len <= 0)
            return -1;
        Node<T> tmp = head;
        int i;
        for (i = 0; i < len; ++i){
            tmp = tmp.next;
            if (value.equals(tmp.value)){
                return i;
            }
        }
        return -2;
    }

    /**
     *
     * @param index
     * @return
     */
    public T next(int index){
        return this.get(index + 1);
    }

    /**
     *
     * @param index
     * @return
     */
    public T prev(int index){
        return this.get(index - 1);
    }

    /**
     *  list tail
     * @return
     */
    public T tail(){
        return tail.next.value;
    }

    /**
     *  list head
     * @return
     */

    public T head(){
        return head.next.value;
    }

    /**
     * push from left
     * @param value
     * @return
     */
    public boolean lpush(T value){
        return this.insert(0, value);
    }

    /**
     * push from right
     * @param value
     * @return
     */
    public boolean rpush(T value){
        return this.add(value);
    }

    /**
     *  插入
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index, T value){
        if (index > len || index < 0){
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        if (index == len){
            return add(value);
        }
        Node<T> now = new Node<>(value);

        if (index == 0){
            Node<T> old = head.next;
            old.prev = now;
            now.next = old;
            now.prev = null;
            head.next = now;
            len++;
            return true;
        }
        Node<T> old = head.next;
        while (index > 0){
            index--;
            old = old.next;
        }
        now.next = old;
        now.prev = old.prev;
        old.prev.next = now;
        old.prev = now;
        len++;
        return true;
    }

    /**
     *  remove node
     * @param index
     * @return
     */
    public T remove(int index){
        if (index >= len || index < 0){
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        Node<T> now = head.next;
        Node<T> temp;
        if (index == 0){
            if (len == 1){
                len--;
                head.next = null;
                tail.next = null;
                return now.value;
            }
            temp = now;
            now = now.next;
            now.prev = null;
            head.next = now;
            len--;
            return temp.value;
        }
        if (index == len - 1){
            Node<T> tails = tail.next;
            tail.next = tails.prev;
            tails.prev.next = null;
            tails.prev = null;
            tails.next = null;
            len--;
            return tails.value;
        }
        while (index > 0){
            index--;
            now = now.next;
        }
        now.prev.next = now.next;
        now.next.prev = now.prev;
        now.prev = null;
        now.next = null;
        len--;
        return now.value;
    }

    public T remove(T value){
        int index = index(value);
        return remove(index);
    }

    public void removeAll(){
        while (len > 0){
            remove(0);
        }
    }


    /**
     *  pop from left
     * @return
     */

    public T lpop(){
        return remove(0);
    }


    /**
     *  pop from right
     * @return
     */
    public T rpop(){
        return remove(len - 1);
    }
}