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
        int ans = getDiameter(root);
        return ans;
    }
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        int rHeight = getHeight(root.right);
        int lHeight = getHeight(root.left);
        int temp = 1 + Math.max(rHeight, lHeight);
        return temp;
    }
    public int getDiameter(TreeNode root){
        if(root == null) return 0;
        int dia1 = getDiameter(root.right);
        int dia2 = getDiameter(root.left);
        int dia3 = getHeight(root.left) + getHeight(root.right);
        return Math.max(dia3,Math.max(dia1, dia2));
    }
}