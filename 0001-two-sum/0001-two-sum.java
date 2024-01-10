class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 1; i < nums.length; i++){
            mp.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int possiblePair = target - nums[i];
            if(mp.containsKey(possiblePair)){
                if(mp.get(possiblePair) == i) continue;
                ans[0] = i;
                ans[1] = mp.get(possiblePair);
                break;
            }
        }
        return ans;
    }
}