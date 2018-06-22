/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
*/

class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0)	return s;
    	
    	String vowels = "aeiouAEIOU";
    	int start = 0;
    	int end = s.length() -1;
    	char[] chars = s.toCharArray();
    	
    	while(start < end){
    		while(start < end && !vowels.contains(chars[start]+"")){
    			start++;
    		}
    		while(start < end && !vowels.contains(chars[end]+"")){
    			end--;
    		}
    		
    		char temp = chars[start];
    		chars[start] = chars[end];
    		chars[end] = temp;
            
            start++;
    		end--;
    	}
    	return String.valueOf(chars);
    }
}
