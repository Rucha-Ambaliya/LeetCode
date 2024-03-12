class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        int ans = 0;

        for (int num : nums) {
            int frequency = map.getOrDefault(num, 0) + 1;
            map.put(num, frequency);
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        for (int frequency : map.values()) {
            if (frequency == maxFrequency) {
                ans += frequency;
            }
        }

        return ans;
    }
}
