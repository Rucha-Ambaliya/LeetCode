class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        int n = nums.length;
        int i = 0;
        while(i != n){
            if(nums[i] != val){
                nums[k++] = nums[i++];
            } else {
                while(i != n && nums[i] == val){
                    i++;
                }
            }
        }
        return k;
    }
}