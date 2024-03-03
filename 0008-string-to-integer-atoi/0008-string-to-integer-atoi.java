class Solution {
    public int myAtoi(String s) {
        int index = 0, sign = 1, result = 0;
        // Handle leading whitespace
        s = s.trim();
        if(s.length() == 0) return 0;
        // Handle sign
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            sign = (s.charAt(index++) == '-') ? -1 : 1;
        }
        // Parse digits
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index++) - '0';
            // Check for overflow
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
        }
        return result * sign;
    }
}
