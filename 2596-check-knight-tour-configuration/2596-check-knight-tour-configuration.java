class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] != 0) return false;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) continue;
                if(!isValid(grid[i][j], grid, i, j)) return false;
            }
        } 
        return true;
    }
    public boolean isValid(int move, int[][] grid, int row, int col){
        int n = grid.length;
        int i = row;
        int j = col;
        
            i += 2;
            if(i < n && j > 0 &&
               grid[i][--j] == move - 1) return true;
            j = col;
            if(i < n && j < n - 1 &&
               grid[i][++j] == move - 1) return true;
            i = row;
            j = col;
            i -= 2;
            if(i >= 0 && j > 0 &&
               grid[i][--j] == move - 1) return true;
            j = col;
            if(i >= 0 && j < n - 1 &&
                    grid[i][++j] == move - 1) return true;
            
            j = col;
            i = row;
            j += 2;
            if(j < n && i < n - 1 && 
               grid[++i][j] == move - 1) return true;
            i = row;
            if(j < n && i > 0 &&
               grid[--i][j] == move - 1) return true;
            j = col;
            i = row;
            j -= 2;
            if(j >= 0 && i > 0 &&
               grid[--i][j] == move - 1) return true;
            i = row;
            if(j >= 0 && i < n - 1 &&
               grid[++i][j] == move - 1) return true;
        
        return false;
    }
}