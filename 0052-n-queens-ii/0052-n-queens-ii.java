class Solution {
    
    public int totalNQueens(int n) {
        int[] numOfAns = new int[1];
        char[][] Board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Board[i][j] = '.';
            }
        }
        getSolution(Board, 0, numOfAns);
        return numOfAns[0];
    }
    
    public void getSolution(char[][] Board, int row, int[] numOfAns){
        int n = Board.length;
        if(row == n){
            numOfAns[0]++;
            return;
        }
        for(int j = 0; j < n; j++){
            if(isSafe(Board, row, j)){
                Board[row][j] = 'Q';
                getSolution(Board, row + 1, numOfAns);
                Board[row][j] = '.';
            }
        }
    }
    
    public boolean isSafe(char[][] Board, int row, int col){
        int i = row;
        int j = col;
        int n = Board.length;
        for(j = 0; j < n; j++){
            if(Board[row][j] == 'Q') return false;
        }
        i = row;
        j = col;
        for(i = 0; i < n; i++){
            if(Board[i][col] == 'Q') return false;
        }
        i = row;
        j = col;
        while(i >= 0 && j >= 0){
            if(Board[i--][j--] == 'Q') return false;
        }
        i = row;
        j = col;
        while(i >= 0 && j < n){
            if(Board[i--][j++] == 'Q') return false;
        }
        i = row;
        j = col;
        while(i < n && j < n){
            if(Board[i++][j++] == 'Q') return false;
        }
        i = row;
        j = col;
        while(i < n && j >= 0){
            if(Board[i++][j--] == 'Q') return false;
        }
        return true;
    }
}