class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0;
        int n = nums.length;
        int sum = 0;
        int[] prefixSumCount = new int[n + 1];
        prefixSumCount[0] = 1; 
        for (int num : nums) {
            sum += num;
            if (sum >= goal) {
                ans += prefixSumCount[sum - goal];
            }
            prefixSumCount[sum]++;
        }
        return ans;
    }
}
