class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            int product = 1;
            int j = i;
            while(product < k && j < n){
                product *= nums[j++];
                if (product < k) { 
                    ans++;
                }
            }
        }
        return ans;
    }
}