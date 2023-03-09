package dsa.DynamicProgramming;

public class LC486 {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return true;

        Integer[][] memo = new Integer[n][n];
        return dfs(nums, 0, n - 1, memo) >= 0;
    }

    private int dfs(int[] nums, int i, int j, Integer[][] memo){
        if (i > j) return 0;
        if (memo[i][j] != null) return memo[i][j];
        memo[i][j] = Math.max(nums[i] - dfs(nums, i + 1, j, memo),
                nums[j] - dfs(nums, i, j - 1, memo));
        return memo[i][j];
    }
}
