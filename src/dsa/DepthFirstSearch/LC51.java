package dsa.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class LC51 {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<>();
        dfs(board, 0, res);
        return res;
    }

    private void dfs(char[][] board, int col, List<List<String>> res){
        if (col == board.length) {
            res.add(construct(board));
        }
        else{
            for (int i = 0; i < board.length; i++){
                if (isValid(board, i, col)){
                    board[i][col] = 'Q';
                    dfs(board, col + 1, res);
                    board[i][col] = '.';
                }
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < col; j++){
                if (board[i][j] == 'Q' && (col - row == j - i || col + row == j + i || row == i))
                    return false;
            }
        }
        return true;
    }

    private List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++){
            res.add(new String(board[i]));
        }
        return res;
    }
}
