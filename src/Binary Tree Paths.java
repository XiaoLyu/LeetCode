/*
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
		if(root != null){
			traverse(root, "", result);
		}
		return result;
	}
	
	public void traverse(TreeNode root, String path, List<String> result){
		if(root.left == null && root.right == null){
			result.add(path + root.val);
		}
		if(root.left != null){
			traverse(root.left, path + root.val + "->", result);
		}
		if(root.right != null){
			traverse(root.right, path + root.val + "->", result);
		}
    }
}
