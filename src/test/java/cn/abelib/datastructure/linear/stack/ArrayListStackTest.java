package cn.abelib.datastructure.linear.stack;

import org.junit.Before;
import org.junit.Test;


/**
 * Created by abel-huang on 2016/12/25.
 * The unit string for ArrayListStack
 */

public class ArrayListStackTest {
    Stack<String> stack = new ArrayListStack<>(10);

    @Before
    public void push() {
        System.out.println(stack.isEmpty());
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
    }

    @Test
    public void pop() {
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
    }

    @Test
    public void peek() {
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.size());
    }
}
