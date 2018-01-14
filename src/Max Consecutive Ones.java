/*
Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
*/

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int[] result = new int[nums.length];
        int max = 0;
        
        if(nums[0] == 1){
            result[0] = 1;
        }
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == 1){
                result[i] = result[i-1] + 1;
            }
        }
        
        for (int i = 0; i < nums.length; i++){
            if(result[i] > max){
                max = result[i];
            }
        }
        
        return max;
    }
}
