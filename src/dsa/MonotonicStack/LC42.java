package dsa.MonotonicStack;

import java.util.*;

public class LC42 {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        int n = height.length;
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                int bottom = stack.pop();
                if (stack.isEmpty())
                    break;
                int minHeight = Math.min(height[stack.peek()], height[i]);
                res += (minHeight - height[bottom]) * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return res;
    }
}
