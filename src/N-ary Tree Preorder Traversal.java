/*
Given an n-ary tree, return the preorder traversal of its nodes' values.

For example, given a 3-ary tree:

Return its preorder traversal as: [1,3,5,6,2,4].

Note:

Recursive solution is trivial, could you do it iteratively?

*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    List<Integer> result = new ArrayList<Integer>();
    
    public List<Integer> preorder(Node root) {
        if(root == null){
    		return result;
    	}
    	else{
    		result.add(root.val);
    		if(root.children == null){
    			return result;
    		}
    		else{
    			int rootSize = root.children.size();
    			for(int i = 0; i < rootSize; i++){
    				preorder(root.children.get(i));
    			}
    		}
    	}
        return result;
    }
}
