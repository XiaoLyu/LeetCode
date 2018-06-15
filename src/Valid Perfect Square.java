/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
*/
// Brute Force
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==1 || num==4)
	 	   return true;
	     int mid=num/2;
	     for(int i=3;i<=mid;i++)
	         if(i*i==num)
	             return true;
	     return false;
    }
}

// 1+3+5+... = N^2
class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
	    while(num > 0){
	    	num -= i;
	    	i += 2;
	    }
	    return num == 0;
    }
}

// Newton's method 牛顿迭代法
// O(1) time Newton's method进阶版：fast inverse square root implementation from Quake III Arena
