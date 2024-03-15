class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProduct = new int[n + 1];
        int[] suffixProduct = new int[n + 1];
        int[] ans = new int[n];
        prefixProduct[0] = suffixProduct[n - 1] = 1;
        
        for(int i = 1; i <= n; i++){
            prefixProduct[i] = prefixProduct[i-1] * nums[i-1];
        }
        for(int i = n - 2; i >= 0; i--){
            suffixProduct[i] = suffixProduct[i+1] * nums[i+1];
        }
        for(int i = 0; i < n; i++){
            ans[i] = prefixProduct[i] * suffixProduct[i];
        }
        return ans;
    }
}