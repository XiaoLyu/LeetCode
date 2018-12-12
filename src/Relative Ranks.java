/*
Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:
Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
For the left two athletes, you just need to output their relative ranks according to their scores.
Note:
N is a positive integer and won't exceed 10,000.
All the scores of athletes are guaranteed to be unique.
*/

class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int[][] pairs = new int[nums.length][2];
    	
    	for(int i = 0; i < nums.length; i++){
    		pairs[i][0] = nums[i];
    		pairs[i][1] = i;
    	}
    	
    	Arrays.sort(pairs, (a, b) -> (b[0]-a[0]));
    	String[] result = new String[nums.length];
    	
    	for(int i = 0; i < nums.length; i++){
    		if(i == 0){
    			result[pairs[i][1]] = "Gold Medal";
    		}
    		else if(i == 1){
    			result[pairs[i][1]] = "Silver Medal";
    		}
    		else if(i == 2){
    			result[pairs[i][1]] = "Bronze Medal";
    		}
    		else{
    			result[pairs[i][1]] = (i+1) + "";
    		}
    	}
    	
    	return result;
    }
}
