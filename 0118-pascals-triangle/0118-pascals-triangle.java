class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        ans.add(pre);
        for(int i = 1; i < numRows; i++){
            List<Integer> curr = new ArrayList<>();
            curr.add(0, 1);
            for(int j = 1; j < i; j++){
                curr.add(j, pre.get(j - 1) + pre.get(j));
            }
            curr.add(1);
            ans.add(curr);
            pre = new ArrayList<>(curr);
        }
        return ans;
    }
}