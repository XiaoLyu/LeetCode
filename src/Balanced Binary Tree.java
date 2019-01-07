/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.

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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
			return true;
		}
		
		int left = depth(root.left);
		int right = depth(root.right);
		if(Math.abs(left-right) > 1){
			return false;
		}
		else{
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}

	public int depth(TreeNode t) {
		if(t == null){
			return 0;
		}
		if(t.left == null && t.right == null){
			return 1;
		}
		else{
			int left = depth(t.left);
			int right = depth(t.right);
			return (Math.max(left, right) + 1);
		}
    }
}
