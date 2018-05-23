/*
Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:
Input: [1,2,2,3,1,4,2]
Output: 6
Note:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.
*/

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<Integer, int[]>(); // [start, end, times]
		int maxFrequency = 0;
		
		for(int i = 0; i < nums.length; i++){
			if(!map.containsKey(nums[i])){
				map.put(nums[i], new int[] {i, i, 1});
				if(1 > maxFrequency){
					maxFrequency = 1;
				}
			}
			else{
				int[] value = map.get(nums[i]);
				value[1] = i;
				value[2]++;
				if(value[2] > maxFrequency){
					maxFrequency = value[2];
				}
				map.put(nums[i], value);
			}
		}
		
		Iterator<Map.Entry<Integer, int[]>> entries = map.entrySet().iterator();
		int length = nums.length;
		  
		while (entries.hasNext()) {  
		  
		    Map.Entry<Integer, int[]> entry = entries.next();  
		    
		    if(entry.getValue()[2] == maxFrequency){
		    	if((entry.getValue()[1] - entry.getValue()[0] + 1) < length){
		    		length = entry.getValue()[1] - entry.getValue()[0] + 1;
		    	}
		    }
		}
		return length;
    }
}
