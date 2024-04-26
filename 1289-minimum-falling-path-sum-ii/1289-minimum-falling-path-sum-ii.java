class Solution {
    public int minFallingPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 1; i < rows; i++){
            int min1 = Integer.MAX_VALUE,
                min2 = Integer.MAX_VALUE;
            for(int j = 0; j < cols; j++){
                if(grid[i-1][j] < min1){
                    min2 = min1;
                    min1 = grid[i-1][j];
                }
                else if(grid[i-1][j] < min2){
                    min2 = grid[i-1][j];
                }
            }
            for(int j = 0; j < cols; j++){
                if(min1 == grid[i-1][j]){
                    grid[i][j] += min2;
                } 
                else{
                    grid[i][j] += min1;
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < cols; j++){
            ans = Math.min(ans, grid[rows-1][j]);
        }
        
        return ans;
    }
}