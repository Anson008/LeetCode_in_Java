package dsa.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC140 {
    private List<String> res = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict){
        int n = s.length();
        List<String>[] dp = new ArrayList[n + 1];
        HashSet<String> wordSet = new HashSet<>(wordDict);

        for (int i = 0; i < dp.length; i++)
            dp[i] = new ArrayList<>();

        dp[0].add("");
        String currStr;
        for (int i = 1; i <= n; i++){
            for (int j = 0; j < i; j++){
                currStr = s.substring(j, i);
                if (!dp[j].isEmpty() && wordSet.contains(currStr)){
                    dp[i].add(currStr);
                }
            }
        }

        getResults(dp, "", n);
        return res;
    }

    private void getResults(List<String>[] dp, String curr, int index){
        if (index == 0){
            res.add(curr.trim());
            return;
        }

        for (String prev : dp[index])
            getResults(dp, prev + " " + curr, index - prev.length());
    }

    public void runTest(String s, List<String> wordDict){
        List<String> res = wordBreak(s, wordDict);
        for (String result : res)
            System.out.println(result);
    }
}
