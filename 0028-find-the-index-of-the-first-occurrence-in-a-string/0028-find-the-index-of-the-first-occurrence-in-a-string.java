class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        int i = 0;
        int n = haystack.length();
        while (i < n) {
            int j = 0;
            int k = i;
            while (j < needle.length() && k < n && haystack.charAt(k) == needle.charAt(j)) {
                j++;
                k++;
                if (j == needle.length()) return i;
            }
            i++;
        }
        return -1;
    }
}
