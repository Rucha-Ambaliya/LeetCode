class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int ans = 0;
        int childIndex = 0;

        for (int cookieSize : s) {
            if (childIndex < g.length && cookieSize >= g[childIndex]) {
                ans++;
                childIndex++;
            }
        }

        return ans;
    }
}
