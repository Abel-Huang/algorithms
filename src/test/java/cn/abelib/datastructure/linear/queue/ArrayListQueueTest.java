package cn.abelib.datastructure.linear.queue;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by abel-huang on 2017/7/30.
 */
public class ArrayListQueueTest {
    Queue<String> queue = new ArrayListQueue<>();

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
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.size());
    }
}
