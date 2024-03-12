class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (var key : map.keySet()) {
            int value = map.get(key);
            max = Math.max(max, value);
        }
        for (var key : map.keySet()) {
            int value = map.get(key);
            if(value == max) ans += value;
        }
        return ans;
    }
}