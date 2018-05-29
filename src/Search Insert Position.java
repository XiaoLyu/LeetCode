/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int result = 0;
        
        if(target < nums[0]){
        	result = 0;
        }
        else if(target > nums[right]){
        	result = right + 1;
        }
        else{
        	while(left < right){
            	int middle = (left + right) / 2;
            	if(nums[middle] > target){
            		right = middle-1;
            		result = middle;
            	}
            	else if(nums[middle] == target){
            		result = middle;
            		left = middle;
            		right = middle;
            	}
            	else if(nums[middle] < target){
            		left = middle + 1;
            		result = middle;
            	}
            }
            if(left == right){
            	if(nums[left] >= target){
            		result = left;
            	}
            	else{
            		result = left + 1;
            	}
            	
            }
        }
        return result;
    }
}
