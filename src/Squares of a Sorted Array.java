/*
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.
*/

class Solution {
    public int[] sortedSquares(int[] A) {
        int ALen = A.length;
        int[] result = new int[ALen];
        
        int i = 0;
        int j = ALen-1;
        
        for(int n = ALen-1; n >= 0; --n){
            if(Math.abs(A[j]) < Math.abs(A[i])){
                result[n] = A[i] * A[i];
                i++;
            }
            else{
                result[n] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }
}
