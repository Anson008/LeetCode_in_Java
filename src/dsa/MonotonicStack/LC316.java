package dsa.MonotonicStack;

import java.util.*;

public class LC316 {
    public String removeDuplicateLetters(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        Set<Integer> visited = new HashSet<>();
        int[] last = new int[128];

        for (int i = 0; i < s.length(); i++){
            last[s.charAt(i)] = i;
        }
        for (int i = 0; i < s.length(); i++){
            int c = s.charAt(i);
            if (!visited.add(c))
                continue;
            while(!stack.isEmpty() && c < stack.peek() && i < last[stack.peek()])
                visited.remove(stack.pop());
            stack.push(c);
        }
        for (int i : stack){
            sb.append((char)i);
        }
        return sb.reverse().toString();
    }
}
