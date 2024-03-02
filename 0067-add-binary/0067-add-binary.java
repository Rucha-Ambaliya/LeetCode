class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int i = 0, r = 0;
        StringBuilder revA = new StringBuilder(a).reverse();
        StringBuilder revB = new StringBuilder(b).reverse();
        int n1 = revA.length(), n2 = revB.length();
        
        while (i < n1 || i < n2 || r > 0) {
            int val = r;
            if (i < n1) val += revA.charAt(i) - '0';
            if (i < n2) val += revB.charAt(i) - '0';
            ans.append(val % 2);
            r = val / 2;
            i++;
        }
        
        return ans.reverse().toString();
    }
}
