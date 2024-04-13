class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int l = 0;
        int r = height.length - 1;
        int lmax = height[l];
        int rmax = height[r];
        while(l < r) {
            if(lmax < rmax) {
                l++;
                lmax = Math.max(lmax, height[l]);
                sum += lmax - height[l];
            } else {
                r--;
                rmax = Math.max(rmax, height[r]);
                sum += rmax - height[r];
            }
        }
        return sum;
    }
}