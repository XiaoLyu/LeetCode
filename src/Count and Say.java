/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
*/

class Solution {
    public String countAndSay(int n) {
      if(n == 1){
    		return "1";
    	}
    	
    	String str = countAndSay(n-1);
    	char[] chars = (str + " ").toCharArray();
    	StringBuilder s = new StringBuilder();
    	int count = 1;
    	for(int i = 0; i < chars.length-1; i++){
    		if(chars[i] == chars[i+1]){
    			count++;
    		}else{
    			s.append(count);
    			s.append(chars[i]);
    			count = 1;
    		}
    	}
    	return String.valueOf(s);
    }
}
