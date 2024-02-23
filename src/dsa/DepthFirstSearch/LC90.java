package dsa.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> currLevel, List<List<Integer>> res){
        res.add(new ArrayList<>(currLevel));

        for (int i = start; i < nums.length; i++){
            if (i != start && nums[i] == nums[i - 1])
                continue;
            currLevel.add(nums[i]);
            dfs(nums, i + 1, currLevel, res);
            currLevel.remove(currLevel.size() - 1);
        }
    }
}
