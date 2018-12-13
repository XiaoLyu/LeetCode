/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
		BFS(root, list, 0);
        Collections.reverse(list);
		return list;
	}
	
	public void BFS(TreeNode root, List<List<Integer>> list, int level){
		if(root == null){
			return;
		}
		
		if(list.size() < (level + 1)){
			List<Integer> levelList = new ArrayList<>();
			list.add(levelList);
		}
		
		list.get(level).add(root.val);
		
		BFS(root.left, list, level+1);
		BFS(root.right, list, level+1);
	}
}
