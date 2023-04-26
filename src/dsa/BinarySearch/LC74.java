package dsa.BinarySearch;

public class LC74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int nrow = matrix.length;
        int ncol = matrix[0].length;
        int left = 0;
        int right = nrow * ncol - 1;
        int mid;

        while (left <= right){
            mid = left + (right - left) / 2;
            int i = mid / ncol;
            int j = mid % ncol;
            if (target < matrix[i][j])
                right = mid - 1;
            else if (target > matrix[i][j])
                left = mid + 1;
            else
                return true;
        }
        return false;
    }
}
