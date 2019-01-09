package cn.abelib.datastructure.linear.linked;

import cn.abelib.datastructure.linear.Queue;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: abel-huang
 * @Date: 2018-12-26 22:54
 */
public class LinkedQueueTest {
    Queue<String> queue = new LinkedQueue<>();

    @Before
    public void enqueue() {
        System.out.println(queue.isEmpty());
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
    }

    @Test
    public void dequeue() {
        System.out.println(queue.isEmpty());
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
    }

    @Test
    public void getFront() {
        System.out.println(queue);
        System.out.println(queue.getFront());
        System.out.println(queue.dequeue());
        System.out.println(queue.getFront());
        System.out.println(queue);
        System.out.println(queue.size());
    }
}
