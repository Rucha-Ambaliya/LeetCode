class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k == n) return "0";

        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // If k > 0, remove remaining digits from the end
        while (k > 0) {
            stack.pop();
            k--;
        }

        // Construct the smallest number from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
