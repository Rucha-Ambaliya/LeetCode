class Solution {
    public int longestIdealString(String s, int k) {
        int[] maxLen = new int[26];
        int currI;
        int n = s.length();
        int ans = 0;
        for(int i = 0; i < n; i++){
            currI = s.charAt(i) - 'a';
            int max = 0;
            for(int j = currI - k; j <= currI + k; j++){
                if(j < 0 || j > 25) continue;
                max = Math.max(max, maxLen[j]);
            }
            maxLen[currI] = max + 1;
        }
        for(int i = 0; i < n; i++){
            int idx = s.charAt(i) - 'a';
            ans = Math.max(ans, maxLen[idx]);
        }
        return ans;
    }
}