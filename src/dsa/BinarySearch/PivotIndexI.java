package dsa.BinarySearch;

public class PivotIndexI {
    public int findPivotIndex(int[] array){
        int n = array.length;
        if (n <= 1)
            return -1;

        int lo = 0, hi = n - 1;
        int mid;
        while (lo <= hi){
            mid = lo + (hi - lo) / 2;
            if (array[mid] < mid)
                lo = mid + 1;
            else if (array[mid] > mid)
                hi = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
