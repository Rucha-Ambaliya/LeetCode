class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++){
            char ch = strs[0].charAt(i);
            for(int j = 1; j < n; j++){
                if(i == strs[j].length() || strs[j].charAt(i) != ch) return ans.toString();
            }
            ans.append(ch);
        }
        return ans.toString();
    }
}
