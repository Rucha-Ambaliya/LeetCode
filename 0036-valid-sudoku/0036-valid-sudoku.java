class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char currentValue = board[row][col];
                board[row][col] = '.';
                if (currentValue != '.' && !isValidValue(currentValue, board, row, col)) {
                    return false;
                }
                board[row][col] = currentValue;
            }
        }
        return true;
    }

    public boolean isValidValue(char value, char[][] board, int row, int col) {
        int n = board.length;

        // Check row and column
        for (int i = 0; i < n; i++) {
            if (board[row][i] == value || board[i][col] == value) {
                return false;
            }
        }

        // Check subgrid
        int rowGrid = (row / 3) * 3;
        int colGrid = (col / 3) * 3;
        for (int i = rowGrid; i < rowGrid + 3; i++) {
            for (int j = colGrid; j < colGrid + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
