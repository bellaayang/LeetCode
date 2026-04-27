/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        backtracking(board);
        
    }

    private boolean backtracking (char[][] board) {
        for (int i = 0; i < 9; i++) { 
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }

                for (char index = '1'; index <= '9'; index++) {
                    if (isValid(board, i, j, index)) {
                        board[i][j] = index;
                        if (backtracking(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }

                    
                }
                  return false;
                
            }
            
        }
        return true;
    }

    private boolean isValid (char[][] board, int row, int col, char index) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == index) {
                return false;
            }
        }

        for (int j = 0; j < 9; j++) {
            if (board[j][col] == index) {
                return false;
            }
            
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == index) {
                    return false;
                }
                
            }
        }

        return true;
    }

    
}
// @lc code=end

