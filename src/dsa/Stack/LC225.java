package dsa.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class LC225 {
    Queue<Integer> q1;
    Queue<Integer> q2;
    int top;

    public LC225() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.offer(x);
        top = x;
    }

    public int pop() {
        while (q1.size() > 1){
            top = q1.poll();
            q2.offer(top);
        }
        int res = q1.poll();
        Queue<Integer> temp = new LinkedList<>();
        temp = q1;
        q1 = q2;
        q2 = temp;
        return res;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
