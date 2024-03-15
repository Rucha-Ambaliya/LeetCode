class Solution {
    public int pivotInteger(int n) {
        int sum = (n * (n + 1)) / 2;
        double sqrt = Math.sqrt(sum);
        int roundedSqrt = (int) Math.round(sqrt);
        return (roundedSqrt * roundedSqrt) == sum ? roundedSqrt : -1;
    }
}
