package io.github.aenyeweddientwink;

import java.util.EmptyStackException;

/**
 * Implementation of a Generic class Stack.
 * @param <T> type of elements of the Stack.
 */
public class Stack<T> {
    private int capacity;
    private int size;
    private T[] stack;

    /**
     * Creates of an object of Stack class.
     */
    public Stack(){
        this.capacity = 4;
        this.size = 0;
        this.stack = (T[]) new Object[capacity];
    }

    /**
     * Pushes an element on the top of the Stack
     * @param elem element to push
     */
    public void push(T elem){
        if (elem == null){
            throw new NullPointerException("Can't push a null");
        }
        if (size == capacity){
            this.capacity *= 2;
            T[] newStack = (T[]) new Object[capacity];
            System.arraycopy(stack,0,newStack,0,size);
            this.stack = newStack;
        }
        this.stack[size++] = elem;
    }

    /**
     * Pops an element off the top of the Stack
     * @return the element that was popped
     */
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

    /**
     * Pops num elements off the top of the stack and returns them in the form of a stack
     * @param num number of elements you want to be popped
     * @return New stack with num elements which were popped
     */
    public Stack<T> popStack(int num){
        if (size < num){
            throw new EmptyStackException();
        }
        Stack<T> newStack = new Stack<>();
        for (int i =(size-num); i < size; i++){
            newStack.push(stack[i]);
        }
        size = size - num;
        if (size <= capacity/2){
            this.capacity = size;
            T[] lessStack = (T[]) new Object[capacity];
            System.arraycopy(stack, 0, lessStack, 0, size);
            this.stack = lessStack;
        }
        return newStack;
    }

    /**
     * Pushes all elements from otherStack to this Stack
     * @param otherStack Stack from which elements will be taken to be pushed
     */
    public void pushStack(Stack<T> otherStack){
        if (otherStack == null){
            throw new NullPointerException("Can't push an empty stack");
        }
        int count = otherStack.count();
        for (int i = 0; i < count;i++){
            push(otherStack.stack[i]);
        }
    }
    public int count(){
        return this.size;
    }

}