class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows)
            return s;
        
        int n = s.length();
        char[][] matrix = new char[numRows][n];
        StringBuilder ans = new StringBuilder();
        int i = 0, j = 0, k = 0;
        while(k < n){
            int cnt = 0;
            while(cnt < numRows && k < n){
                matrix[i++][j] = s.charAt(k++);
                cnt++;
            }
            i -= 2;
            j++;
            while(cnt > 2 && k < n){
                matrix[i--][j++] = s.charAt(k++);
                cnt--;
            }
        }
        for(i = 0; i < numRows; i++){
            for(j = 0; j < n; j++){
                if(matrix[i][j] != '\u0000')
                    ans.append(matrix[i][j]);
            }
        }
        return ans.toString();
    }
}
