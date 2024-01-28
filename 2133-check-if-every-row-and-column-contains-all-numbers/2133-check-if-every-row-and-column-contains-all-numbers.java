class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        boolean[] arr = new boolean[n + 1];
        int j = 0;
        while(j < n){
            for(int i = 0; i < n; i++){
                arr[matrix[j][i]] = true;
            }
            for(int i = 1; i < n + 1; i++){
                if(!arr[i]) return false;
                arr[i] = false;
            }
            j++;
        }
        j = 0;
        while(j < n){
            for(int i = 0; i < n; i++){
                arr[matrix[i][j]] = true;
            }
            for(int i = 1; i < n + 1; i++){
                if(!arr[i]) return false;
                arr[i] = false;
            }
            j++;
        }
        
        return true;
    }
}