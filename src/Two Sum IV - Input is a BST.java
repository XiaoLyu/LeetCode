/*
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<Integer>();
		addList(root, list);
		boolean result = false;
		for(int l : list){
			if(list.contains(k-l) && (k != 2*l)){
				result = true;
				break;
			}
		}
		return result;
	}

	public void addList(TreeNode root, List<Integer> list){
		list.add(root.val);
		if(root.left != null){
			addList(root.left, list);
		}
		if(root.right != null){
			addList(root.right, list);
		}
    }
}
