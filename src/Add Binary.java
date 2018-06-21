/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
*/

class Solution {
    public String addBinary(String a, String b) {
         StringBuilder result = new StringBuilder();
        int carry = 0;
        
        for(int i = a.length()-1, j = b.length()-1; i >= 0 || j >= 0 || carry == 1; i--, j--){
        	int a2Int = i < 0 ? 0 : a.charAt(i)-'0';
        	int b2Int = j < 0 ? 0 : b.charAt(j)-'0';
        	int sum = (a2Int + b2Int + carry) % 2;
        	carry = (a2Int + b2Int + carry) / 2;
        	result.append(sum);
        }
        return result.reverse().toString();
    }
}
