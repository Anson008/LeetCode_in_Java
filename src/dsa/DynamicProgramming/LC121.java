package dsa.DynamicProgramming;

public class LC121 {
    public int maxProfit(int[] prices){
        final int n = prices.length;
        if (n == 1)
            return 0;

        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[n - 1][0];
    }

    public int maxProfitGreedy(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            profit = Math.max(profit, price - minPrice);
        }

        return profit;
    }

    public void runTest(int[] prices){
        System.out.println(maxProfit(prices));
    }
}
