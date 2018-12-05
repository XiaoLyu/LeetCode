/*
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
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
    List<Integer> list = new ArrayList<>();
	int dif = Integer.MAX_VALUE;

	public int getMinimumDifference(TreeNode root) {
		traverse(root);
		
		for(int i = 1; i < list.size(); i++){
			int dValue = Math.abs(list.get(i) - list.get(i-1));
			if(dValue < dif){
				dif = dValue;
			}
		}
		return dif;
	}
	
	public void traverse(TreeNode cur){
		if(cur != null){
			traverse(cur.left);
			list.add(cur.val);
			traverse(cur.right);
		}
	}
}
