package dsa.Array;

import java.util.Arrays;

public class LC435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int res = 0;
        int currentEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] >= currentEnd)
                currentEnd = intervals[i][1];
            else
                res++;
        }
        return res;
    }
}
