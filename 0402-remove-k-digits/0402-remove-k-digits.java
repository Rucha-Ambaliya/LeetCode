class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k == n) return "0";

        char[] stack = new char[n];
        int top = -1; // Pointer to the top of the stack

        for (char digit : num.toCharArray()) {
            while (k > 0 && top >= 0 && stack[top] > digit) {
                top--; // Remove digits until stack is empty or top digit is smaller than current digit
                k--;
            }
            stack[++top] = digit; // Push current digit onto the stack
        }

        // If k > 0, remove remaining digits from the end
        while (k > 0) {
            top--;
            k--;
        }

        // Construct the smallest number from the array
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // Skip leading zeros
        while (i <= top && stack[i] == '0') {
            i++;
        }
        // Append digits to StringBuilder
        while (i <= top) {
            sb.append(stack[i++]);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
