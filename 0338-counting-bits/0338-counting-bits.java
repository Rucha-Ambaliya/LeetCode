class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for(int i = 1; i < n + 1; i++){
            ans[i] = cntOnes(i);
        }
        return ans;
    }
    public int cntOnes(int n){
        int cnt = 0;
        while(n != 0){
            if((n & 1) == 1) cnt++;
            n = n >> 1;
        }
        return cnt;
    }
}