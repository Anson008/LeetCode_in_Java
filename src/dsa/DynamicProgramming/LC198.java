package dsa.DynamicProgramming;

public class LC198 {
    public int rob(int[] nums){
        final int n = nums.length;
        // dp[i]: maximum amount you can rob until the ith house.
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i < n + 1; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[n];
    }

    public void runTest(int[] nums){
        System.out.println(rob(nums));
    }
}
