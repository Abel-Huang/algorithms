package cn.abelib.test.sort.heap;

import cn.abelib.basic.util.StdIO;
import cn.abelib.sort.priority.heap.MinPriorityQueue;

/**
 * Created by huangjianjin on 2017/7/30.
 */
public class HeapTest {
    public static void main(String [] args){
//        MaxPriorityQueue<Integer> maxPriorityQueue = new MaxPriorityQueue<>(10);
//        StdIO.println("The maxpq is Empty: "+maxPriorityQueue.isEmpty());
//        maxPriorityQueue.insert(3);
//        maxPriorityQueue.insert(1);
//        maxPriorityQueue.insert(2);
//        StdIO.println("The size: "+maxPriorityQueue.size());
//        StdIO.println("Delete the max item: "+maxPriorityQueue.delMax());
//        StdIO.println("The size: "+maxPriorityQueue.size());

        MinPriorityQueue<Integer> minPriorityQueue = new MinPriorityQueue<>(8);
        StdIO.println("The minpq is Empty: "+minPriorityQueue.isEmpty());
        minPriorityQueue.insert(5);
        minPriorityQueue.insert(1);
        StdIO.println("The size: "+minPriorityQueue.size());
        minPriorityQueue.insert(4);
        minPriorityQueue.insert(3);
        minPriorityQueue.insert(2);
        StdIO.println("The size: "+minPriorityQueue.size());
        StdIO.println("Delete the min item: "+minPriorityQueue.delMin());
        StdIO.println("The size: "+minPriorityQueue.size());

//        Double [] a = RandomData.randDoubleArray(10, 10);
//        Double [] b = a;
//        StdIO.print(b);
//        Double [] c =new Double[10];
//        StdIO.print(c.length);
//        c[1] = 1.0;
//        StdIO.print(c.length);
    }
}
