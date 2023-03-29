package dsa.DynamicProgramming;

import java.util.Arrays;

public class LC300 {
    public int lengthOfLIS(int[] nums){
        final int n = nums.length;
        int[] dp = new int[n];  // dp[i]: max length of increasing subsequence ending with nums[i].
        Arrays.fill(dp, 1);

        int res = 1;
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                res = Math.max(res, dp[i]);
            }
        }

        return res;
    }

    public int lengthOfLISBS(int[] nums){
        final int n = nums.length;
        int[] dp = new int[n];
        int size = 0;

        for (int num : nums) {
            int position = firstNotLessThan(dp, size, num);
            dp[position] = num;
            if (position == size)
                size++;
        }
        return size;
    }

    private int firstNotLessThan(int[] dp, int size, int target){
        int left = 0;
        int right = size - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (dp[mid] >= target)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}
