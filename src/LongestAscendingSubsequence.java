public class LongestAscendingSubsequence {
    private static int[] memo;

    public static void main(String[] args){
        int[] arr = {5};
        int res = longest(arr);
        System.out.println(String.format("Longest is %d", res));
        for (int i = 0; i < memo.length; i++){
            System.out.println(String.format("Memo[%d] = %d", i, memo[i]));
        }
    }

    public static int longest(int[] array){
        int n = array.length;
        if (n == 0)
            return 0;

        memo = new int[n + 1];
        for (int i = 0; i < n + 1; i++){
            memo[i] = -1;
        }

        dfs(array, n);

        int max = 0;
        for (int i = 0; i < n + 1; i++){
            if (max < memo[i])
                max = memo[i];
        }
        return max;
    }

    private static int dfs(int[] arr, int n){
        if (n == 1){
            memo[n] = 1;
            return memo[n];
        }
        if (memo[n] != -1)
            return memo[n];

        int max_ending_here = 1;
        int res;
        for (int i = 1; i < n; i++){
            res = dfs(arr, i);
            if (arr[i - 1] < arr[n - 1]) {
                if (max_ending_here < res + 1)
                    max_ending_here = res + 1;
            }
        }
        if (memo[n] < max_ending_here) {
            memo[n] = max_ending_here;
            //System.out.println(String.format("memo[%d] = %d", n, max_ending_here));
        }
        return max_ending_here;
    }
}
