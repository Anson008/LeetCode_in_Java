package dsa.DynamicProgramming;

public class LC1140 {

    private int[] suffixSum;
    private int[][] dp;
    public int stoneGameII(int[] piles){
        final int n = piles.length;
        suffixSum = piles.clone();
        dp = new int[n][n];

        for (int i = n - 2; i >= 0; i--){
            suffixSum[i] += suffixSum[i + 1];
        }

        return dfs(0, 1);
    }

    private int dfs(int x, int M){
        if (dp.length - x <= 2 * M) return suffixSum[x];
        if (dp[x][M] > 0) return dp[x][M];

        int opponent = suffixSum[x];
        for (int i = 1; i <= 2 * M; i++){
            opponent = Math.min(opponent, dfs(x + i, Math.max(i, M)));
        }

        return dp[x][M] = suffixSum[x] - opponent;
    }

    public void runTest(int[] piles){
        int res = stoneGameII(piles);
        System.out.println(res);
    }
}
