package cn.abelib.datastructure.linear.queue.priority;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by abel-huang on 2017/7/22.
 */
public class HeapPriorityQueueTest {
    private PriorityQueue<Integer> priorityQueue;

    @Before
    public void enqueueTest() {
        priorityQueue = new HeapPriorityQueue<>(10);
        System.out.println(priorityQueue.isEmpty());
        priorityQueue.enqueue(4);
        priorityQueue.enqueue(2);
        priorityQueue.enqueue(1);
        priorityQueue.enqueue(3);
    }

    @Test
    public void dequeueTest() {
        System.out.println(priorityQueue.isEmpty());
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.size());
        System.out.println(priorityQueue.isEmpty());
    }

    @Test
    public void peekTest() {
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.size());
    }
}