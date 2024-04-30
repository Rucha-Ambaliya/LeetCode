class Solution {
    public long wonderfulSubstrings(String word) {
        long result = 0;
        long cumXor = 0;
        
        HashMap<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        
        for (int i = 0; i < word.length(); i++) {
            char currCh = word.charAt(i);
            int shift = currCh - 'a';
            
            cumXor ^= (1 << shift);
            
            result += map.getOrDefault(cumXor, 0L);
            
            for(char ch = 'a'; ch <= 'j'; ch++){
                shift = ch - 'a';
                
                long isVisted = (cumXor ^ (1 << shift));
                
                result += map.getOrDefault(isVisted, 0L);
            }
            
            map.put((long) cumXor, map.getOrDefault(cumXor, 0L) + 1L);
        }
        
        return result;
    }
}