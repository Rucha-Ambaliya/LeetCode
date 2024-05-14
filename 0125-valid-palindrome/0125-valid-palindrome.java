class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                str.append(Character.toLowerCase(ch));
            }
        }
        int n = str.length();
        StringBuilder half = new StringBuilder(str.substring(n / 2 + n % 2, n)); 
        str.delete(n/2, n);
        
        return str.toString().equals(half.reverse().toString());
    }
}
