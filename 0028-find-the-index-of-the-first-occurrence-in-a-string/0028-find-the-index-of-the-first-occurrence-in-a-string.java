class Solution {
    public int strStr(String haystack, String needle) {
        int found = haystack.indexOf(needle);
        if(found >= 0){
            return found;
        }
        return -1;
    }
}