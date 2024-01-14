/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        int ans = getAns(root);
        return ans;
    }
    public int getAns(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int level = 0;
        int maxLevel = 0;
        while(q.size() != 0){
            if(q.peek() != null){
                TreeNode currNode = q.remove();
                int currVal = currNode.val;
                sum += currVal;
                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right != null) q.add(currNode.right);
            } 
            else{
                level++;
                q.remove();
                if(sum > maxSum){
                    maxSum = sum;
                    maxLevel = level;
                } 
                sum = 0;
                if(q.size() != 0) q.add(null);
            }
        }
        return maxLevel;
    }
}