class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[] dp = new int[c];
        int ans = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(matrix[i][j] == '1')
                    dp[j]++;
                else
                    dp[j] = 0;
            }
            ans = Math.max(ans, largestRectangleArea(dp));
        }
        return ans;
    }
    
    public int largestRectangleArea(int[] heights) {
        int size = heights.length;
        int[] pse = new int[size];
        int[] nse = new int[size];
        Stack<Integer> stack = new Stack<>();
        
        //previous smaller element
        for(int i = 0; i < size; i++){
            pse[i] = -1;
            while(stack.size() > 0 && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            if(stack.size() != 0){
                pse[i] = stack.peek();
            }
            stack.push(i);
        }
        //emtying stack;
        while (stack.size() > 0) {
            stack.pop();
        }
        //next smaller element
        for(int i = size - 1; i >= 0; i--){
            nse[i] = size;
            while(stack.size() > 0 && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            if(stack.size() == 0){
                nse[i] = size;
            }
            else {
                nse[i] = stack.peek();
            }  
            stack.push(i);
        }
        //calculating largest rectangle area
        int maxArea = 0;
        for (int i = 0; i < size; i++) {
            int area = heights[i] * (nse[i] - pse[i] - 1);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}