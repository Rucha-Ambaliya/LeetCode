import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> h = new HashMap<>();
        for(var c : s.toCharArray()){
            h.put(c, h.getOrDefault(c, 0) + 1);
        }
        for(var c : t.toCharArray()){
            if(h.get(c) == null || h.get(c) == 0) return false;
            else{
                h.put(c, h.get(c) - 1);
            }
        }
        return true;
    }
}
