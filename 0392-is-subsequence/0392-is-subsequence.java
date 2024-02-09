class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = t.length();
        int m = s.length();
        
        if (m == 0) return true;
        if (m > n) return false;
        
        int i = 0;
        int j = 0;
        
        while(i != n){
            char ch = t.charAt(i);
            if(ch == s.charAt(j)){
                j++;
                if(j == m) return true;
            }
            i++;
        }
        return false;
    }
}