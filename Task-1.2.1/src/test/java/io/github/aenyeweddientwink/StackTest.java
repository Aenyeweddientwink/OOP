package io.github.aenyeweddientwink;

import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for the Stack class
 */
public class StackTest {

    @Test
    void stackcreationTest(){
        Stack<String> stack = new Stack<>();
        assertEquals(0,stack.count());
    }

    @Test
    void popfromemptystackTest(){
        Stack<String> stack = new Stack<>();
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    void pushnullpointerTest(){
        Stack<String> stack = new Stack<>();
        assertThrows(NullPointerException.class, ()->stack.push(null));
        assertThrows(NullPointerException.class, ()-> stack.pushStack(null));
    }

    @Test
    void capacityTest(){
        Stack <Integer> stack = new Stack<>();
        for (int i = 0; i < 8; i++){
            stack.push(1);
        }
        assertEquals(8,stack.count());
    }
    @Test
    void simpleTest(){
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3,stack.count());

        assertEquals(3,stack.pop());
        assertEquals(2,stack.count());
    }
    @Test
    void pushStackTest(){
        Stack<String> newstack = new Stack<>();
        Stack<String> oldstack = new Stack<>();
        oldstack.push("Hello");
        oldstack.push("World");
        String[] array = {"1","2","3","4"};
        for(int i = 0; i < 4; i++)
        {
            oldstack.push(array[i]);
        }
        newstack.pushStack(oldstack);
        assertEquals(6,newstack.count());
        assertEquals("4",newstack.pop());
        assertEquals("3",newstack.pop());
        assertEquals(4,newstack.count());
    }

    @Test
    void popStackTest(){
        Stack<Integer> stack =  new Stack<>();
        for (int i = 0; i <5; i++){
            stack.push(i);
        }
        assertEquals(5,stack.count());
        Stack<Integer> stack1 = stack.popStack(3);
        assertEquals(3,stack1.count());
        assertEquals(1,stack.pop());
    }





}
