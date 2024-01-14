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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return getAns(root, subRoot);
    }

    public boolean getAns(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;

        if (isEqual(root, subRoot)) {
            return true;
        }

        return getAns(root.left, subRoot) || getAns(root.right, subRoot);
    }

    private boolean isEqual(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;

        return node1.val == node2.val &&
               isEqual(node1.left, node2.left) &&
               isEqual(node1.right, node2.right);
    }
}
