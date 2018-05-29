/*
Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
Note:
1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].
*/

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int length = nums.length - k + 1;
		int[] array = new int[length];
		
		for(int i = 0; i < length; i++){
			for(int j = 0; j < k; j++){
				array[i] = array[i] + nums[i+j];
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < length; i++){
			if(array[i] > max){
				max = array[i];
			}
		}
		
		return (double)max/k;
    }
}
