package dsa.HashTable;

import java.util.*;

public class LC36 {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == '.')
                    continue;
                char c = board[i][j];
                if (!seen.add(c + "@row" + i) || !seen.add(c + "@col" + j) || !seen.add(c + "@box" + i / 3 + j / 3))
                    return false;
            }
        }
        return true;
    }
}
