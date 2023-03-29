package dsa.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC20 {
    public boolean isValid(String s){
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()){
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }

        return stack.isEmpty();
    }

    public void runTest(String s){
        System.out.println(isValid(s));
    }
}
