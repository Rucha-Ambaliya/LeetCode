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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode tempLeft = root;
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = tempLeft;
            return newRoot;
        }
        getNewTree(root, val, depth, 1);
        return root;
    }
    public void getNewTree(TreeNode root, int val, int depth, int currDepth) {
        if (root == null) return;
        if (currDepth == depth - 1) {
            TreeNode tempLeft = root.left;
            TreeNode tempRight = root.right;
            root.left = new TreeNode(val);
            root.right = new TreeNode(val);
            root.left.left = tempLeft;
            root.right.right = tempRight;
            return;
        }
        getNewTree(root.left, val, depth, currDepth + 1);
        getNewTree(root.right, val, depth, currDepth + 1);
    }
}