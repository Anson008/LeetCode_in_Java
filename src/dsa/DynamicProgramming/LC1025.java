package dsa.DynamicProgramming;

public class LC1025 {
    public boolean divisorGameI(int n){
        boolean[] dp = new boolean[n + 1];
        dp[1] = false;
        for (int j = 2; j <= n; j++){
            for (int i = 1; i <= j / 2; i++){
                if (j % i == 0 && !dp[j - i]){
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public boolean divisorGameR(int n){
        Boolean[] memo = new Boolean[n + 1];
        return dfs(n, memo);
    }

    private boolean dfs(int n, Boolean[] memo){
        if (n == 1) return false;
        if (memo[n] != null) return memo[n];

        boolean canWin = false;
        for (int i = 1; i <= n / 2; i++){
            if (n % i == 0 && !dfs(n - i, memo)){
                canWin = true;
                break;
            }
        }
        return memo[n] = canWin;
    }
}
