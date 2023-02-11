package io.github.aenyeweddientwink;

import java.util.EmptyStackException;

/**
 * Implementation of a Generic class Stack
 * @param <T> type of elements of the Stack
 */
public class Stack<T> {
    private int capacity;
    private int size;
    private T[] stack;

    public Stack(){
        this.capacity = 4;
        this.size = 0;
        this.stack = (T[]) new Object[capacity];
    }

    public void push(T elem){
        if (size == capacity){
            this.capacity *= 2;
            T[] newStack = (T[]) new Object[capacity];
            System.arraycopy(stack,0,newStack,0,size);
            this.stack = newStack;
        }
        this.stack[size++] = elem;
    }
    public T pop(){
        if (size == 0){
            throw new EmptyStackException();
        }
        if (size <= capacity/2){
            this.capacity = size;
            T[] newStack = (T[]) new Object[capacity];
            System.arraycopy(stack,0,newStack,0,size);
            this.stack = newStack;
        }
        this.size--;
        return this.stack[size];
    }
    public int count(){
        return this.size;
    }

}