class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int badIdx = -1, minIdx = -1, maxIdx = -1;

        for (int currIdx = 0; currIdx < nums.length; currIdx++) {
            if (!(nums[currIdx] >= minK && nums[currIdx] <= maxK)) {
                badIdx = currIdx;
            }

            if (nums[currIdx] == minK) {
                minIdx = currIdx;
            }

            if (nums[currIdx] == maxK) {
                maxIdx = currIdx;
            }

            ans += Math.max(0, Math.min(minIdx, maxIdx) - badIdx);
        }

        return ans;
    }
}
