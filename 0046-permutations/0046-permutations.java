class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> helper = new ArrayList<Integer>();
        boolean[] hasTaken = new boolean[nums.length];
        getP(nums, ans, helper, hasTaken);
        return ans;
    }
    public void getP(int[] nums, List<List<Integer>> ans, List<Integer> helper, boolean[] hasTaken){
        if(helper.size() == nums.length){
            ans.add(new ArrayList<>(helper));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(hasTaken[i]) continue;
            int num = nums[i];
            helper.add(num);
            hasTaken[i] = true;
            getP(nums, ans, helper, hasTaken);
            hasTaken[i] = false;
            helper.remove(helper.size() - 1);
        }
    }
}