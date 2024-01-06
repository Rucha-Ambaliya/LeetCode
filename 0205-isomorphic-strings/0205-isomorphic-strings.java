class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mp = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char key = s.charAt(i);
            for(var entry : mp.entrySet()){
                if(
                    (key == entry.getKey() && entry.getValue() != t.charAt(i)) ||
                    (key != entry.getKey() && entry.getValue() == t.charAt(i))
                ) return false;
            }
            mp.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
}