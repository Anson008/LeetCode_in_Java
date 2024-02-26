package dsa.MonotonicStack;

import java.util.*;

public class LC503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 2*n - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[i % n] >= stack.peek())
                stack.pop();
            res[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;
    }
}
