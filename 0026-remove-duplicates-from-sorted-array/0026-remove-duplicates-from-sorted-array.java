class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int newIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.add(nums[i])) {
                nums[newIndex++] = nums[i];
            }
        }
        return newIndex;
    }
}
