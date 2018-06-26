/*
Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]
*/

class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
    	for(int i = 0; i < s.length(); i = i + 2*k){
    		int j = i;
    		int m = Math.min(s.length()-1, i + k - 1);
    		while(j < m){
    			char temp = chars[j];
    			chars[j++] = chars[m];
    			chars[m--] = temp;
    		}
    	}
    	return String.valueOf(chars);
    }
}
