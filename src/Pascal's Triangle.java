/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

/*
注意list的操作
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(numRows > 0){
        	// row = 1
        	result.add(new ArrayList<Integer>());
        	result.get(0).add(1);
        	
        	// row = 2, 3...
        	for(int rowNum = 1; rowNum < numRows; rowNum++){
        		List<Integer> row = new ArrayList<>();
        		List<Integer> pre = result.get(rowNum-1);
        		
        		row.add(1);
        		
        		for(int j = 1; j < rowNum; j++){
        			row.add(pre.get(j-1) + pre.get(j));
        		}
        		
        		row.add(1);
        		
        		result.add(row);
        	}
        	
	    }
        return result; 
    }
}
