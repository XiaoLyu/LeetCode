/*
Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.

For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
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
	public void DFS(TreeNode root, List<Integer> leafList){
		if(root != null){
			if(root.left == null && root.right == null){
				leafList.add(root.val);
			}
			DFS(root.left, leafList);
			DFS(root.right, leafList);
		}
	}
	
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    	List<Integer> list1 = new ArrayList<Integer>();
    	List<Integer> list2 = new ArrayList<Integer>();
    	DFS(root1, list1);
    	DFS(root2, list2);
    	
    	return list1.equals(list2);
    }
}
