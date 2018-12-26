package cn.abelib.datastructure.linear.linked;

import cn.abelib.datastructure.linear.Stack;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: abel-huang
 * @Date: 2018-12-26 22:37
 */
public class LinkedStackTest {
    Stack<Integer> stack = new LinkedStack<>();


    @Before
    public void push(){
        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        System.out.println(stack.isEmpty());
    }

    @Test
    public void pop(){
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
    }

    @Test
    public void peek(){
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.size());
    }
}
