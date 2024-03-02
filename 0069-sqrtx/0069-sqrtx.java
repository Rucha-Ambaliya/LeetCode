class Solution {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        if (x == 2) return 1;
        for (int i = 1; i < x; i++) {
            if (x - i * i < 0) return i - 1;
        }
        return -1;
    }
}
