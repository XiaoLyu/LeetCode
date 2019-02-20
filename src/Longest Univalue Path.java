/*
Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output:

2
Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output:

2
Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int longestUnivaluePath(TreeNode root) {
        if(root != null)    dfs(root);
        return res;
    }

    int res = 0;
    
    private int dfs(TreeNode node) {
        int l = (node.left == null) ? 0: dfs(node.left);
        int r = (node.right == null) ? 0: dfs(node.right);
        int lConnect = (node.left != null && node.val == node.left.val) ? l+1 : 0;
        int rConnect = (node.right != null && node.val == node.right.val) ? r+1 : 0;
        res = Math.max(res, lConnect + rConnect);
        return Math.max(lConnect, rConnect);
    }

}
