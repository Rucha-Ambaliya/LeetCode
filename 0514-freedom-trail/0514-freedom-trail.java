class Solution {
    HashMap<Character, Set<Integer>> map;
    int[][] dp;
    public int findRotateSteps(String ring, String key) {
        int rLength = ring.length();
        int kLength = key.length();
        dp = new int[rLength][kLength];
        map = new HashMap();
        
        for(int i = 0; i < rLength; i++){
            char c = ring.charAt(i);
            map.putIfAbsent(c, new HashSet());
            map.get(c).add(i);
        }
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        
        return getMinSteps(ring , 0, key, 0) + kLength;
    }
    
    public int getMinSteps(String ring , int r, String key, int k){
        if(k == key.length()) return 0;
        if(dp[r][k] != -1) return dp[r][k];
        
        int min = Integer.MAX_VALUE;
        for(int next : map.get(key.charAt(k))){
            int oneWay = Math.abs(next - r);
            int steps = Math.min(oneWay, ring.length() - oneWay);
            min = Math.min(min,steps + getMinSteps(ring , next, key, k + 1));
        }
        dp[r][k] = min;
        
        return min;
    }
}