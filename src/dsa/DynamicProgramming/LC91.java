package dsa.DynamicProgramming;

public class LC91 {
    public int numDecodings(String s){
        if (s == null || s.isEmpty())
            return 0;

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = isValid(s.charAt(n - 1)) ? 1 : 0;

        for (int i = n - 2; i >= 0; i--){
            if (isValid(s.charAt(i))){
                dp[i] += dp[i + 1];
            }
            if (isValid(s.charAt(i), s.charAt(i + 1))){
                dp[i] += dp[i + 2];
            }
        }

        return dp[0];
    }

    public void runTest(String s){
        System.out.println(numDecodings(s));
    }

    private boolean isValid(char c){
        return c != '0';
    }

    private boolean isValid(char c1, char c2){
        return c1 == '1' || (c1 == '2' && c2 < '7');
    }
}
