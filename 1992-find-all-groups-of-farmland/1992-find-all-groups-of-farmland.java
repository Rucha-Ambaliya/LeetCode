class Solution {
    public int[][] findFarmland(int[][] land) {
        int rows = land.length;
        int cols = land[0].length;
        List<List<Integer>> farmlands = new ArrayList<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (
                    land[i][j] == 1 && 
                    (i == 0 || land[i - 1][j] == 0) && 
                    (j == 0 || land[i][j - 1] == 0)
                ) {
                    
                    int bottomRow = i;
                    int rightCol = j;

                    while (bottomRow + 1 < rows && land[bottomRow + 1][j] == 1) {
                        bottomRow++;
                    }
                    
                    while (rightCol + 1 < cols && land[i][rightCol + 1] == 1) {
                        rightCol++;
                    }

                    List<Integer> farmland = new ArrayList<>();
                    farmland.add(i);
                    farmland.add(j);
                    farmland.add(bottomRow);
                    farmland.add(rightCol);
                    farmlands.add(farmland);
                }
            }
        }
        
        int[][] result = new int[farmlands.size()][4];
        for (int i = 0; i < farmlands.size(); i++) {
            List<Integer> farmland = farmlands.get(i);
            for (int j = 0; j < 4; j++) {
                result[i][j] = farmland.get(j);
            }
        }
        
        return result;
    }
}