class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int num : nums){
            set.add(num);
        }
        int maxLength = 0;
        for(int num : set){
            if(!set.contains(num - 1)){
                int currNum = num;
                int currStreak = 1;
                while(set.contains(currNum + 1)){
                    currStreak++;
                    currNum++;
                }
                maxLength = Math.max(currStreak, maxLength);
            }
        }
        return maxLength;
    }
}