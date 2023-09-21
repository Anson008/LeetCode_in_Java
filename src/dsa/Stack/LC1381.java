package dsa.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC1381 {
    int n;
    int[] inc;
    Deque<Integer> stack = new ArrayDeque<>();

    public LC1381(int maxSize) {
        n = maxSize;
        inc = new int[n];
    }

    public void push(int x) {
        if (stack.size() < n) stack.push(x);
    }

    public int pop() {
        int i = stack.size() - 1;
        if (i < 0) return -1;
        if (i > 0) inc[i - 1] += inc[i];
        int res = stack.pop() + inc[i];
        inc[i] = 0;
        return res;
    }

    public void increment(int k, int val) {
        int i = Math.min(k, stack.size()) - 1;
        if (i >= 0) inc[i] += val;
    }
}
