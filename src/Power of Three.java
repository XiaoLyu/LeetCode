/*
Given an integer, write a function to determine if it is a power of three.

Example 1:

Input: 27
Output: true
Example 2:

Input: 0
Output: false
Example 3:

Input: 9
Output: true
Example 4:

Input: 45
Output: false
Follow up:
Could you do it without using any loop / recursion?
*/

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0)	return false;
        while(n >= 1){
        	if(n == 1)	return true;
        	else{
        		if(n % 3 != 0){
        			return false;
        		}
        		n = n/3;
        	}
        }
        return true;
    }
}

//由于输入是int，正数范围是0-2^31，在此范围中允许的最大的3的次方数为3^19=1162261467
class Solution {
    public boolean isPowerOfThree(int n) {
        return (n >0 && 1162261467 % n == 0);
    }
}

// 换底公式为logab = logcb / logca
class Solution {
    public boolean isPowerOfThree(int n) {
        return (n > 0 &&  (int)(Math.log10(n)/Math.log10(3)) - Math.log10(n)/Math.log10(3) == 0);
    }
}
