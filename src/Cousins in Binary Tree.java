/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
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
    public boolean isCousins(TreeNode root, int x, int y) {
        BFS(root, x, y, null,0);
        if(xDep == yDep && xP != yP)    return true;
        else
            return false;
    }
    
    TreeNode xP = null;
    TreeNode yP = null;
    int xDep = -1;
    int yDep = -1;
    
    public void BFS(TreeNode node, int x, int y, TreeNode parent, int depth){
        if(node == null)    return;
        if(node.val == x){
            xP = parent;
            xDep = depth;
        }
        else if(node.val == y){
            yP = parent;
            yDep = depth;
        }
        BFS(node.left, x, y, node, depth+1);
        BFS(node.right, x, y, node, depth+1);
    }
}
