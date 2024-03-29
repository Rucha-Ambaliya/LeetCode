class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        int n = nums.length;
        int FofMax = 0;
        long ans = 0;
        int right = 0, left = 0;
        for(int num : nums){
            max = Math.max(max, num);
        }
        while(right < n){
            int num = nums[right];
            if(num == max) FofMax++;
            while(FofMax >= k && left < n){
                ans += n - right;
                if(nums[left++] == max) FofMax--;
            }
            right++;
        }
        return ans;
    }
}