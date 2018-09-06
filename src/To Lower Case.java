/*
Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

 

Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"
*/

class Solution {
    public String toLowerCase(String str) {
        char[] arr = str.toCharArray();
		StringBuilder s = new StringBuilder();
        for(char c: arr){
        	if(Character.isUpperCase(c)){
            	char newC = (char)(c+32);
            	s.append(newC);
        	}
        	else{
        		s.append(c);
        	}
        }
        return String.valueOf(s);
    }
}
