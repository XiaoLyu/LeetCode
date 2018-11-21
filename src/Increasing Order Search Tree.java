/*
Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9  
Note:

The number of nodes in the given tree will be between 1 and 100.
Each node will have a unique integer value from 0 to 1000.
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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
		 DFS(root, list);
		 
		 TreeNode newNode = new TreeNode(0);
		 TreeNode cur = newNode;
		 int len = list.size();
		 for(int i = 0; i < len; i++){
			 cur = cur.right = new TreeNode(list.get(i));
		 }
		 return newNode.right;
	 }
	 
	 public void DFS(TreeNode root, List<Integer> list){
		 if(root == null){
			 return;
		 }
		 DFS(root.left, list);
		 list.add(root.val);
		 DFS(root.right, list);
     }
}
