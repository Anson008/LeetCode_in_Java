package dsa.DepthFirstSearch;

public class LC79 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;
        if (word == null || word.isEmpty())
            return false;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        char[] chars = word.toCharArray();

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (dfs(board, chars, visited, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] chars, boolean[][] visited, int i, int j, int level){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        if (visited[i][j] || board[i][j] != chars[level])
            return false;
        if (level == chars.length - 1)
            return true;

        visited[i][j] = true;
        level++;
        boolean hasPath = (dfs(board, chars, visited, i + 1, j, level) ||
                dfs(board, chars, visited, i - 1, j, level) ||
                dfs(board, chars, visited, i, j + 1, level) ||
                dfs(board, chars, visited, i, j - 1, level) );
        visited[i][j] = false;
        return hasPath;
    }
}
