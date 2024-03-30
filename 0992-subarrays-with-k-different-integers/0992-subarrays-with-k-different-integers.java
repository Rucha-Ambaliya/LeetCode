class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }
    
    private int atMostKDistinct(int[] nums, int k) {
        int left = 0;
        int count = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            
            while (freq.size() > k) {
                int leftNum = nums[left];
                freq.put(leftNum, freq.get(leftNum) - 1);
                if (freq.get(leftNum) == 0) {
                    freq.remove(leftNum);
                }
                left++;
            }
            
            // Add the count of subarrays formed by the current window
            count += right - left + 1;
        }

        return count;
    }
}
