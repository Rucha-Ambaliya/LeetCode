class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int ans = 0;

        for (int i = 0, j = 0; i < n; i++) {
            char ch = s.charAt(i);

            while (set.contains(ch)) {
                set.remove(s.charAt(j));
                j++;
            }

            set.add(ch);
            ans = Math.max(ans, i - j + 1);
        }

        return ans;
    }
}
