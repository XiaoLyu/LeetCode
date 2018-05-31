/*
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
*/

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length == 0)	return 0;
    	
    	Map<Double, Integer> map = new HashMap<Double, Integer>();
    	int result = 0;
    	
    	for(int i = 0; i < points.length; i++){
    		int[] A = points[i];
    		
    		for(int j = 0; j < points.length; j++){
    			if(j != i){
    				int[] curr = points[j];
    				double value = Math.pow(A[0]-curr[0], 2) + Math.pow(A[1]-curr[1], 2);
    				if(map.containsKey(value)){
    					result = result + 2* map.get(value);
    					map.put(value, map.get(value)+1);
    				}
    				else{
    					map.put(value, 1);
    				}
    			}
    		}
    		map.clear();
    	}
        return result;
    }
}
