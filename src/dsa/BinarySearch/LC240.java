package dsa.BinarySearch;

public class LC240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int nrow = matrix.length;
        int ncol = matrix[0].length;
        int i = 0, j = ncol - 1;

        while (i < nrow && j >= 0){
            if (target < matrix[i][j])
                j--;
            else if (target > matrix[i][j])
                i++;
            else
                return true;
        }
        return false;
    }

    public void runTest(int[][] matrix, int target){
        System.out.println(searchMatrix(matrix, target));
    }
}
