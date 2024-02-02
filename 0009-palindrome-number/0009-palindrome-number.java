class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int y = x;
        int n = 0;
        while(y != 0){
            n++;
            y /= 10;
        }
        int[] nums = new int[n];
        y = x;
        for(int i = 0; y != 0; i++){
            nums[i] = y % 10;
            y /= 10;
        }
        for(int i = 0, j = n - 1; i < j; i++, j--){
            if(nums[i] != nums[j]) return false;
        }
        return true;
    }
}