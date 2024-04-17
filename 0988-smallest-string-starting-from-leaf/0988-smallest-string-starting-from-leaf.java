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
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder result = new StringBuilder();
        dfs(root, new StringBuilder(), result);
        return result.toString();
    }
    
    private void dfs(TreeNode node, StringBuilder path, StringBuilder result) {
        if (node == null) return;
        
        path.append((char)('a' + node.val));
        
        if (node.left == null && node.right == null) { // Leaf node
            String pathString = path.reverse().toString();
            if (result.length() == 0 || pathString.compareTo(result.toString()) < 0) {
                result.setLength(0); // Clear previous result
                result.append(pathString);
            }
            path.reverse(); // Reverse back to restore original path
        }
        
        // Recursively explore left and right subtrees
        dfs(node.left, path, result);
        dfs(node.right, path, result);
        
        // Backtrack: remove the last character from the path
        path.deleteCharAt(path.length() - 1);
    }
}
