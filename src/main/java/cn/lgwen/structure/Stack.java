package cn.lgwen.structure;

import java.util.LinkedList;
import java.util.List;

public class Stack<T> {

    private int top = 0;

    private List<T> arrays;

    public Stack() {
        this.arrays = new LinkedList<>();
    }

    public void push(T t) {
        arrays.add(t);
        top ++;
    }

    public T pop() {
        if (top <= 0) {
            throw new RuntimeException("count pop element from a empty stack");
        }
        return arrays.remove((top--) - 1);
    }

    public T peek() {
        if (top <= 0) {
            throw new RuntimeException("count peek element from a empty stack");
        }
        return arrays.get(top - 1);
    }

    public boolean isEmpty() {
        return top <= 0;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            System.out.println(stack.pop());
        }
    }

}
