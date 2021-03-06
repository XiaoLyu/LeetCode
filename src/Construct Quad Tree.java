/*
We want to use quad trees to store an N x N boolean grid. Each cell in the grid can only be true or false. The root node represents the whole grid. For each node, it will be subdivided into four children nodes until the values in the region it represents are all the same.

Each node has another two boolean attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node. The val attribute for a leaf node contains the value of the region it represents.

Your task is to use a quad tree to represent a given grid. The following example may help you understand the problem better:

Given the 8 x 8 grid below, we want to construct the corresponding quad tree:

It can be divided according to the definition above:

The corresponding quad tree should be as following, where each node is represented as a (isLeaf, val) pair.

For the non-leaf nodes, val can be arbitrary, so it is represented as *.

Note:

N is less than 1000 and guaranteened to be a power of 2.
If you want to know more about the quad tree, you can refer to its wiki.
*/

/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node construct(int[][] grid) {
        return buildTree(grid, 0, 0, grid.length);
    }
    
    public Node buildTree(int[][] grid, int x, int y, int len){
    	Node node = new Node();
    	if(allSame(grid, x, y, len)){
    		node.isLeaf = true;
    		node.val = (grid[x][y] == 1);
    		return node;
    	}
    	else{
    		node.topLeft = buildTree(grid, x, y, len/2);
    		node.topRight = buildTree(grid, x, y + len/2, len/2);
    		node.bottomLeft = buildTree(grid, x + len/2, y, len/2);
    		node.bottomRight = buildTree(grid, x + len/2, y + len/2, len/2);
    	}
    	return node;
    }
    
    public boolean allSame(int[][] grid, int x, int y, int len){
    	int value = grid[x][y];
    	for(int i = x; i < (x + len); i++){
    		for(int j = y; j < (y + len); j++){
    			if(grid[i][j] != value){
    				return false;
    			}
    		}
    	}
    	return true;
    }
}
