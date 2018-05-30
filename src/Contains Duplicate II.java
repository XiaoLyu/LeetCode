/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: [1,2,3,1], k = 3
Output: true
Example 2:

Input: [1,0,1,1], k = 1
Output: true
Example 3:

Input: [1,2,1], k = 0
Output: false
*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		boolean result = false;
		
		for(int i = 0; i < nums.length; i++){
			if(!map.containsKey(nums[i])){
				map.put(nums[i], new ArrayList<Integer>());
				map.get(nums[i]).add(i);
			}
			else{
				map.get(nums[i]).add(i);
			}
		}
		
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {  
			  
		    int length = entry.getValue().size();
		    if(length > 1){
		    	for(int i = 1; i < length; i++){
		    		if(entry.getValue().get(i) - entry.getValue().get(i-1) <= k){
		    			result = true;
		    		}
		    	}
		    }
		}  
		return result;
    }
}
