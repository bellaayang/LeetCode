/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<String>> result = new LinkedList<>();
    char[][] chessBoard;
    public List<List<String>> solveNQueens(int n) {
        chessBoard = new char[n][n];
        for (char[] row : chessBoard) {
            Arrays.fill(row, '.');
        }
        backtracking(n, 0);
        return result;

        
    }

    private void backtracking (int n, int row) {
        if (row == n) {
            
            result.add(arrayToList(chessBoard));
            return;
        } 

        for (int col = 0; col < n; col++) {
            if (isValid (row, col, n, chessBoard)){
                chessBoard[row][col] = 'Q';
                backtracking(n, row + 1);
                chessBoard[row][col] = '.';      
            }
            
        }
    }

    private List arrayToList (char[][] chessBoard) {
        List<String> path = new LinkedList<>();
        for (char[] c : chessBoard) {
            path.add(String.copyValueOf(c));            
        }
        return path;
    }
        

    private boolean isValid (int row, int col, int n, char[][] chessBoard) {
        for (int i = 0; i < row; i++) {
            if (chessBoard[i][col] == 'Q') {
                return false;
            }
            
        }

       for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }

       }

       for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
       }

       return true;

        
        
    }
    

    
}
// @lc code=end

