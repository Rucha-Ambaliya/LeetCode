class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mp = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (mp.containsKey(sChar)) {
                if (mp.get(sChar) != tChar) {
                    return false;
                }
            } else if (mp.containsValue(tChar)) {
                return false;
            }
            mp.put(sChar, tChar);
        }
        return true;
    }
}