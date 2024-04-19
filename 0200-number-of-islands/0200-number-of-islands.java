class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    if(!isPartOfIsland(grid, i, j)) ans++;
                }
            }
        }
        return ans;
    }
    
    public boolean isPartOfIsland(char[][] grid, int r, int c){
        int rows = grid.length;
        int cols = grid[0].length;
        if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != '1'){
            return true; 
        }
        
        // Mark current cell as visited
        grid[r][c] = '2';
        
        // Check adjacent cells recursively
        isPartOfIsland(grid, r+1, c);
        isPartOfIsland(grid, r-1, c);
        isPartOfIsland(grid, r, c+1);
        isPartOfIsland(grid, r, c-1);
        
        return false; 
    }
}
