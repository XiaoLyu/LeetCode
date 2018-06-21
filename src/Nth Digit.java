/*
Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
*/

// 注意溢出（long）
class Solution {
    public int findNthDigit(int n) {
      int len = 1;
    	long cou = 9;
    	int remain = n;
    	int start = 1;
    	
    	while(remain - len * cou > 0){
    		remain = (int)(remain - len * cou);
    		len++;
    		cou = cou * 10;
    		start = start * 10;
    	}
    	
    	start = start + (remain-1) / len;
    	String s = Integer.toString(start);
    	return s.charAt((remain-1)%len)-'0';
    }
}
