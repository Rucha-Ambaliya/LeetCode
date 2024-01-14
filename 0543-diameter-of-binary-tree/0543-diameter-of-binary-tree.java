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
    public int diameterOfBinaryTree(TreeNode root) {
        TreeInfo ans = getDiameter(root);
        return ans.diam;
    }
    class TreeInfo{
        int ht;
        int diam;
        TreeInfo(int ht, int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }
    public TreeInfo getDiameter(TreeNode root) {
        if (root == null) return new TreeInfo(0, 0);

        TreeInfo lInfo = getDiameter(root.left);
        TreeInfo rInfo = getDiameter(root.right);

        int height = Math.max(lInfo.ht, rInfo.ht) + 1;

        int rootDiam = lInfo.ht + rInfo.ht;
        
        int diam = Math.max(Math.max(lInfo.diam, rInfo.diam), rootDiam);

        return new TreeInfo(height, diam);
    }
}