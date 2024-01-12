class Solution {
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] Board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Board[i][j] = '.';
            }
        }
        getSolution(Board, 0, ans);
        return ans;
    }
    
    public void getSolution(char[][] Board, int row, List<List<String>> ans){
        int n = Board.length;
        if(row == n){
            convertToList(Board, ans);
            return;
        }
        for(int j = 0; j < n; j++){
            if(isSafe(Board, row, j)){
                Board[row][j] = 'Q';
                getSolution(Board, row + 1, ans);
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
    
    public void convertToList(char[][] Board, List<List<String>> ans) {
        List<String> strList = new ArrayList<>();
        for (var string : Board) {
            StringBuilder s = new StringBuilder();
            for (var ch : string) {
                s.append(ch);
            }
            strList.add(s.toString());
        }
        ans.add(strList);
    }
}