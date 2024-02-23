package dsa.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), res, new boolean[nums.length]);
        return res;
    }

    private void dfs(int[] nums, List<Integer> currLevel, List<List<Integer>> res, boolean[] used){
        if (currLevel.size() == nums.length){
            res.add(new ArrayList<>(currLevel));
        }
        else{
            for (int i = 0; i < nums.length; i++){
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                    continue;
                currLevel.add(nums[i]);
                used[i] = true;
                dfs(nums, currLevel, res, used);
                currLevel.remove(currLevel.size() - 1);
                used[i] = false;
            }
        }
    }
}
