class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows)
            return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int direction = 1; // 1 for down, -1 for up
        int currentRow = 0;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            currentRow += direction;
            if (currentRow == 0 || currentRow == numRows - 1) {
                direction *= -1; // Change direction when reaching top or bottom row
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
