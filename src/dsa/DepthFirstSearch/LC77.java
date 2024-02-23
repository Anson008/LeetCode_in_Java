package dsa.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class LC77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int n, int k, int start, List<Integer> currLevel, List<List<Integer>> res){
        if (currLevel.size() == k){
            res.add(new ArrayList<>(currLevel));
        }
        else{
            for (int i = start; i <= n; i++){
                currLevel.add(i);
                dfs(n, k, i + 1, currLevel, res);
                currLevel.remove(currLevel.size() - 1);
            }
        }
    }
}
