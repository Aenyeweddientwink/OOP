package io.github.aenyeweddientwink;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTest {
    @Test
    void simpleTest(){
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(stack.count(),3);

        assertEquals(stack.pop(),3);
        assertEquals(stack.count(),2);
    }
}
