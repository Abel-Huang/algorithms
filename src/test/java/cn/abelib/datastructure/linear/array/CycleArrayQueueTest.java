package cn.abelib.datastructure.linear.array;

import cn.abelib.datastructure.linear.Queue;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: abel-huang
 * @Date: 2018-12-17 23:31
 */
public class CycleArrayQueueTest {
    Queue<String> queue = new CycleArrayQueue<>();

    @Before
    public void enqueue(){
        System.out.println(queue.isEmpty());
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
    }

    @Test
    public void dequeue(){
        System.out.println(queue.isEmpty());
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
    }

    @Test
    public void getFront(){
        System.out.println(queue);
        System.out.println(queue.getFront());
        System.out.println(queue.dequeue());
        System.out.println(queue.getFront());
        System.out.println(queue);
        System.out.println(queue.size());
    }
}
