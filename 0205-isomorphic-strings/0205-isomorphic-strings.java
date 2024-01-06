class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mp = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            if(
                (
                    mp.containsKey(s.charAt(i)) && //contains key but not same value
                    mp.get(s.charAt(i)) != t.charAt(i)
                ) ||
                (
                    !mp.containsKey(s.charAt(i)) && //doesn't contain key but value exist
                    mp.containsValue(t.charAt(i))
                )
            ) return false;
            mp.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
}