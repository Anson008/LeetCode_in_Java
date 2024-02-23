package dsa.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class LC78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> currLevel, List<List<Integer>> res){
        res.add(new ArrayList<>(currLevel));

        for (int i = start; i < nums.length; i++){
            currLevel.add(nums[i]);
            dfs(nums, i + 1, currLevel, res);
            currLevel.remove(currLevel.size() - 1);
        }
    }

    public void runTest(int[] nums){
        System.out.println(subsets(nums));
    }
}
