class Solution {
    public void solveSudoku(char[][] board) {
        int n = board.length;
        char[][] helper = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                helper[i][j] = board[i][j];
            }
        }
        getSolution(helper, 0, 0, board);
    }

    public void getSolution(char[][] helper, int row, int col, char[][] board) {
        int n = helper.length;
        if (row == n) {
            for (int k = 0; k < n; k++) {
                for(int l = 0; l < n; l++){
                    board[k][l] = helper[k][l];
                }
            }
            return;
        }
        int i = row;
        int j = col;
        if (helper[i][j] != '.') {
            if (j < n - 1) {
                getSolution(helper, i, j + 1, board);
            } else {
                getSolution(helper, i + 1, 0, board);
            }
        } else {
            for (char ch = '1'; ch <= '9'; ch++) {
                if (!doesExist(ch, helper, i, j)) {
                    helper[i][j] = ch;
                    if (j < n - 1) {
                        getSolution(helper, i, j + 1, board);
                    } else {
                        getSolution(helper, i + 1, 0, board);
                    }
                    helper[i][j] = '.';
                }
            }
        }
    }

    public boolean doesExist(char value, char[][] helper, int row, int col) {
        int n = helper.length;
        for (int i = 0; i < n; i++) {
            if (helper[row][i] == value || helper[i][col] == value) {
                return true;
            }
        }
        // Check subgrid
        int rowGrid = (row / 3) * 3;
        int colGrid = (col / 3) * 3;
        for (int i = rowGrid; i < rowGrid + 3; i++) {
            for (int j = colGrid; j < colGrid + 3; j++) {
                if (helper[i][j] == value) {
                    return true;
                }
            }
        }
        return false;
    }
}
