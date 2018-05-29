/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int[] tempArray = new int[nums.length];
		tempArray[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
        	if(nums[i] > (nums[i] + tempArray[i-1])){
        		tempArray[i] = nums[i];
        	}
        	else{
        		tempArray[i] = (nums[i] + tempArray[i-1]);
        	}
        }
        
        int max = tempArray[0];
        for(int i = 1; i < tempArray.length; i++){
        	if(tempArray[i] > max){
        		max = tempArray[i];
        	}
        }
        return max;
    }
}
