/*
We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
Example:
Input: 28
Output: True
Explanation: 28 = 1 + 2 + 4 + 7 + 14
Note: The input number n will not exceed 100,000,000. (1e8)
*/

class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num <= 2) return false;
        int result = 1;
        
        int div = 2;
        int remain = num/2;
        
        for(div = 2; div < remain; div++){
        	remain = num/div;
        	if(num % div == 0){
        		result = result + div + remain;
        	}
        }
        
        if(result == num){
        	return true;
        }
        else{
        	return false;
        }
    }
}
