class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0) && getAns(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean getAns(char[][] board, String word, int r, int c, int idx) {
        if (idx == word.length()) return true;
        int n = board.length;
        int m = board[0].length;
        if (r < 0 || c < 0 || r == n || c == m || board[r][c] != word.charAt(idx))
            return false;
        
        char temp = board[r][c];
        board[r][c] = '*'; // Mark the current cell as visited
        
        boolean found = getAns(board, word, r, c + 1, idx + 1) ||
                        getAns(board, word, r, c - 1, idx + 1) ||
                        getAns(board, word, r + 1, c, idx + 1) ||
                        getAns(board, word, r - 1, c, idx + 1);

        board[r][c] = temp; // Backtrack by restoring the original character

        return found;
    }
}
