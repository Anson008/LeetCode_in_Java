package dsa.DynamicProgramming;

import java.util.HashSet;
import java.util.List;

public class LC139 {
    public boolean wordBreak(String s, List<String> wordDict){
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        HashSet<String> wordSet = new HashSet<>(wordDict);

        dp[0] = true;
        for (int i = 1; i <= n; i++){
            for (int j = 0; j < i; j++){
                if (dp[j] && wordSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public void runTest(String s, List<String> wordDict){
        System.out.println(wordBreak(s, wordDict));
    }
}
