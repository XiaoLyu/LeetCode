/*
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
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
    int result = 0;
	
	public int sumOfLeftLeaves(TreeNode root) {
		sum(root);
		return result;
	}
	
	public void sum(TreeNode cur){
		if(cur != null){
			sum(cur.left);
			sum(cur.right);
			if(cur.left != null){
				if(cur.left.left == null && cur.left.right == null){
					result += cur.left.val;
				}
			}
		}
	}
}
