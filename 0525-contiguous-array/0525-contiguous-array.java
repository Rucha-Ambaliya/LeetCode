class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int maxlen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 1) cnt++;
            else cnt--;
            
            if(map.containsKey(cnt)) maxlen = Math.max(maxlen, i - map.get(cnt));
            else map.put(cnt, i);
        }
        return maxlen;
    }
}
