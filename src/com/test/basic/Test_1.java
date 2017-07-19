package com.test.basic;

import com.main.basic.collection.LinkedList;


/**
 * Created by huangjianjin on 2016/12/25.
 */
public class Test_1 {
    public static void main(String []args) {
////        FixedCapacityStackOfStrings s=new FixedCapacityStackOfStrings(10);
////        s.push("hehe");
////        System.out.println(s.size());
////        s.pop();
////        System.out.println(s.size());
////        FixedCapacityStack<String> ss=new FixedCapacityStack<>(10);
////        ss.push("hehe");
////        System.out.println(ss.size());
////        ss.pop();
////        ss.push(1+"");
////        ss.push("hehe");
////        System.out.println(ss.size());
////        Stack<Integer> stack=new Stack<>();
////        System.out.println(" ");
////        stack.push(1);
////        stack.push(2);
////        stack.push(3);
////        stack.push(4);
////        stack.push(5);
////        stack.push(6);
////        stack.pop();
////        stack.pop();
////        stack.pop();
////        for(Integer i:stack){
////            System.out.println(i);
////        }
////        System.out.println(stack.size());
////        Queue<Integer> queue=new Queue<>();
////        queue.enqueue(1);
////        System.out.println(queue.size());
////        queue.enqueue(2);
////        System.out.println(queue.size());
////        System.out.println(queue.dequeue());
////        System.out.println(queue.size());
////        System.out.println(queue.dequeue());
////        System.out.println(queue.size());
////        LinkedStack<Integer> linkedStack=new LinkedStack<>();
////        linkedStack.push(1);
////        linkedStack.push(2);
////        linkedStack.push(3);
////        System.out.println(linkedStack.size());
////        System.out.println(linkedStack.pop());
////        System.out.println(linkedStack.size());
////        linkedStack.push(1);
////        linkedStack.push(2);
////        linkedStack.push(3);
////        for(Integer i:linkedStack){
////            System.out.println(i);
////        }
////        System.out.println(linkedStack.size());
////        LinkedQueue<Integer> linkedQueue=new LinkedQueue<>();
////        linkedQueue.enqueue(1);
////        linkedQueue.enqueue(2);
////        linkedQueue.enqueue(3);
////        for(Integer i:linkedQueue){
////            System.out.println(i);
////        }
////        System.out.println(linkedQueue.dequeue());
////        System.out.println(linkedQueue.size());
////        System.out.println(linkedQueue.dequeue());
////        System.out.println(linkedQueue.dequeue());
////     }
//        Bag<Integer> bag=new Bag<>();
//        bag.add(1);
//        bag.add(2);
//        bag.add(3);
//        bag.add(4);
//        System.out.println(bag.size());
//        for(Integer i: bag){
//            System.out.println(i);
//        }
//        FixedCapacityStackOfStrings fixedCapacityStackOfStrings=new FixedCapacityStackOfStrings(3);
//        fixedCapacityStackOfStrings.push("a");
//        System.out.println(fixedCapacityStackOfStrings.isFull());
//        fixedCapacityStackOfStrings.push("a");
//        System.out.println(fixedCapacityStackOfStrings.isFull());
//        fixedCapacityStackOfStrings.push("a");
//        System.out.println(fixedCapacityStackOfStrings.isFull());

//        Stack<Integer> stack=new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        System.out.println(stack.peek());
//        System.out.println(stack.size());
//        System.out.println(stack.peek());
//        System.out.println(stack.size());
//
//        LinkedStack<Integer> linkedStack=new LinkedStack<>();
//        linkedStack.push(1);
//        linkedStack.push(2);
//        linkedStack.push(3);
//        System.out.println(linkedStack.peek());
//        System.out.println(linkedStack.size());
//        System.out.println(linkedStack.peek());
//        System.out.println(linkedStack.size());
        LinkedList<Integer> linkedList=new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
//        for (Integer i:linkedList){
//            System.out.print(i);
//        }
//        System.out.println("--------------");
//        System.out.println(linkedList.size());
//        System.out.println(linkedList.delTail());
//        System.out.println(linkedList.size());
//        System.out.println("--------------");
//        for (Integer i:linkedList){
//            System.out.print(i);
//        }
        System.out.println("--------------");
        linkedList.delete(4);
        linkedList.delete(3);
       System.out.println(linkedList.get(3));
        for (Integer i:linkedList){
            System.out.print(i);
        }
    }
}
