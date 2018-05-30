/*
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.
*/

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null) return 0;
	    if(nums.length == 0 || nums.length == 1) return 0;
	    
	    int max = Integer.MIN_VALUE;
	    int end = 0;
	    
	    for(int i = 0; i < nums.length; i ++){
	        max = Math.max(max, nums[i]);
	        if(nums[i] < max)
	            end = i;
	    }
	    
	    int min = Integer.MAX_VALUE;
	    int begin = 1;
	   
	    for(int i = nums.length - 1; i >= 0; i --){
	        min = Math.min(min, nums[i]);
	        if(nums[i] > min)
	            begin = i;
	    }
	    
	    return end - begin + 1;
    }
}
