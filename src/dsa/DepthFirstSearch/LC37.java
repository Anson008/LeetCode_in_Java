package dsa.DepthFirstSearch;

public class LC37 {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == '.'){
                    for (char c = '1'; c <= '9'; c++){
                        if (isValid(board, i, j, c)){
                            board[i][j] = c;
                            if (solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char c){
        for (int row = 0; row < 9; row++){
            if (board[row][j] == c)
                return false;
        }

        for (int col = 0; col < 9; col++){
            if (board[i][col] == c)
                return false;
        }

        int block_r_start = (i / 3) * 3;
        int block_c_start = (j / 3) * 3;
        for (int row = block_r_start; row < block_r_start + 3; row++){
            for (int col = block_c_start; col < block_c_start + 3; col++){
                if (board[row][col] == c)
                    return false;
            }
        }

        return true;
    }
}
