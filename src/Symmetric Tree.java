/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
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
    public boolean isSymmetric(TreeNode root) {
        boolean result = true;
		if(root== null){
			return result;
		}
		else{
			result = isS(root.left, root.right);
		}
		return result;
	}
	
	public boolean isS(TreeNode left, TreeNode right){
		boolean result = true;
		if(left == null && right == null){
			return result;
		}
		
		if((left == null && right != null) || (left != null && right == null)){
			result = false;
			return result;
		}
		
		if(left != null && right != null && left.val != right.val){
			result = false;
			return result;
		}
		
		if(left != null && right != null && left.val == right.val){
			boolean l = isS(left.left, right.right);
			boolean r = isS(left.right, right.left);
			if(l == false || r == false){
				result = false;
				return result;
			}
		}
		
		return result;
    }
}
