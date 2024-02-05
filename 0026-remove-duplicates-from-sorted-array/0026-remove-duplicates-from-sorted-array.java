class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int newIndex = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (set.add(nums[i])) {
                nums[newIndex++] = nums[i];
            }
        }
        return newIndex;
    }
}
