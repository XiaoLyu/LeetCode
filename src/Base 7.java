/*
Given an integer, return its base 7 string representation.

Example 1:
Input: 100
Output: "202"
Example 2:
Input: -7
Output: "-10"
Note: The input will be in range of [-1e7, 1e7].
*/

class Solution {
    public String convertToBase7(int num) {
        int abNum = Math.abs(num);
    	
    	int len = pos(abNum);
    	
    	int[] result = new int[len+1];
    	
    	int rest = abNum;
    	
    	for(int i = 0; i < (len + 1); i++){
    		if(rest != 0){
    			int l = pos(rest);
        		int val = (int)(rest / (Math.pow(7, l)));
        		result[len-l] = val;
        		rest = rest - (int)Math.pow(7, l) * val;
    		}
    	}
    	
    	String s = "";
    	if(num < 0){
    		s = "-" + s;
    	}
    	for(int i : result){
    		s = s + i + "";
    	}
    	return s;
    }
    
    public int pos(int n){
    	int i = 0;
    	while(n / 7 > 0){
    		i++;
    		n = n/7;
    	}
    	return i;
    }
}
