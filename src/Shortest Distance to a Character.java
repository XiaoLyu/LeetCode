/*
Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

Example 1:

Input: S = "loveleetcode", C = 'e'
Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 

Note:

S string length is in [1, 10000].
C is a single character, and guaranteed to be in string S.
All letters in S and C are lowercase.
*/

class Solution {
    public int[] shortestToChar(String S, char C) {
        List<Integer> indexList = new ArrayList<Integer>();
    	int a = S.indexOf(C);
    	while(a != -1){
    		indexList.add(a);
    		a = S.indexOf(C, a+1);
    	}

    	int[] result = new int[S.length()];
    	for(int i = 0; i < S.length(); i++){
    		int r = Integer.MAX_VALUE;
    		for(int j = 0; j < indexList.size(); j++){
    			int cIndex = indexList.get(j);
    			if(Math.abs(cIndex-i) < r){
    				r = Math.abs(cIndex-i);
    			}
    		}
    		result[i] = r;
    	}
    	return result;
    }
}
