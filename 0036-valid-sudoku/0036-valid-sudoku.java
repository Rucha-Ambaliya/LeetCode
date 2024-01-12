class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                char ch = board[i][j];
                board[i][j] = '.';
                if(ch != '.' && !isValid(ch, board, i, j)){
                    return false;
                }
                board[i][j] = ch;
            }
        }
        return true;
    }
    public boolean isValid(char value, char[][] board, int row, int col){
        int n = board.length;
        for(int i = 0; i < n; i++){
            if(board[row][i] == value) return false;
            if(board[i][col] == value) return false;
        }
        int rGrid = (row/3) * 3;
        int cGrid = (col/3) * 3;
        for(int i = rGrid; i < rGrid + 3; i++){
            for(int j = cGrid; j < cGrid + 3; j++){
                if(board[i][j] == value) return false;
            }
        }
        return true;
    }
}