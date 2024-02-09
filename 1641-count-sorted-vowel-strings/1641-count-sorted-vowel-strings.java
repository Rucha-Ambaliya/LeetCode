class Solution {
    public int countVowelStrings(int n) {
        int[] dp = new int[n + 1];
        return countVowelStringsHelper(n, 0, dp);
    }
    
    private int countVowelStringsHelper(int n, int start, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if(dp[n] != 0) return dp[n];
        int count = 0;
        for (int i = start; i < 5; i++) {
            count += countVowelStringsHelper(n - 1, i, dp);
        }
        
        return count;
    }
}
