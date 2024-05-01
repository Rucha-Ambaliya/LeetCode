class Solution {
    public String reversePrefix(String word, char ch) {
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == ch){
                word = reverse(word.substring(0, i+1)) + (i+1 < word.length() ? word.substring(i+1) : "");
                break;
            }
        }
        return word;
    }
    public String reverse(String str){
        StringBuilder result = new StringBuilder(str);
        return result.reverse().toString();
    }
}