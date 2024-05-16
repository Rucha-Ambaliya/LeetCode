class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        int i = 0, count = 0;
        while(i < n){
            int j = i + 1;
            while(j < n && j - i <= k){
                if(nums[j] == nums[i]) return true;
                j++;
                count++;
                if (count > 99999) {
                    return false;
                }
            }
            i++;
        }
        return false;
    }
}