class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int n = nums.length;
        for(i = 0; i < n && nums[i] <= target; i++){
            if(nums[i] == target) return i;
        }
        return i;
    }
}