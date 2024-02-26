package dsa.Array;

import java.util.*;

public class LC1272 {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved){
        List<List<Integer>> res = new ArrayList<>();
        for (int[] curr : intervals){
            if (curr[1] < toBeRemoved[0] || curr[0] >= toBeRemoved[1]){
                res.add(Arrays.asList(curr[0], curr[1]));
            }
            else {
                if (curr[0] < toBeRemoved[0]){
                    res.add(Arrays.asList(curr[0], toBeRemoved[0]));
                }
                if (curr[1] > toBeRemoved[1]){
                    res.add(Arrays.asList(toBeRemoved[1], curr[1]));
                }
            }
        }
        return res;
    }

}
