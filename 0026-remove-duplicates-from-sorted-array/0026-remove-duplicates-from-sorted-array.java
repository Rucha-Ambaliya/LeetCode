class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
           set.add(nums[i]); 
        }
        int m = set.size();
        int[] temp = new int[m];
        int i = 0;
        for(int num : set){
            temp[i++] = num;
        }
        Arrays.sort(temp);
        i = 0;
        for(int num : temp){
            nums[i++] = num;
        }
        return m;
    }
}