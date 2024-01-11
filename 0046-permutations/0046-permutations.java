class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        getP(nums, ans, 0);
        return ans;
    }
    public void getP(int[] nums, List<List<Integer>> ans, int idx){
        if(idx == nums.length - 1){
            List<Integer> helper = new ArrayList<>();
            for(int num : nums){
                helper.add(num);
            }
            ans.add(helper);
            return;
        }
        for(int i = idx; i < nums.length; i++){
            swap(i, idx, nums);
            getP(nums, ans, idx + 1);
            swap(i, idx, nums);
        }
    }
    public void swap(int i, int idx, int[] nums){
        int temp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = temp;
    }
}