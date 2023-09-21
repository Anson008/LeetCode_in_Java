package dsa.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC155 {
    private Deque<int[]> stack;

    public LC155() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack.isEmpty()){
            stack.push(new int[]{val, val});
        }
        else{
            stack.push(new int[]{val, Math.min(val, stack.peek()[1])});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
