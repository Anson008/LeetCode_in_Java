package dsa.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class LC46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, List<Integer> currLevel, List<List<Integer>> res){
        if (currLevel.size() == nums.length){
            res.add(new ArrayList<>(currLevel));
        }
        else{
            for (int i = 0; i < nums.length; i++){
                if (currLevel.contains(nums[i]))
                    continue;
                currLevel.add(nums[i]);
                dfs(nums, currLevel, res);
                currLevel.remove(currLevel.size() - 1);
            }
        }
    }
}
