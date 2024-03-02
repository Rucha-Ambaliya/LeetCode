class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        
        long start = 1;
        long end = x;
        long result = 0;
        
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long sqr = mid * mid;
            
            if (sqr == x) {
                return (int) mid;
            } else if (sqr < x) {
                start = mid + 1;
                result = mid;
            } else {
                end = mid - 1;
            }
        }
        
        return (int) result;
    }
}
