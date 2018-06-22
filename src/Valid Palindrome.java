/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.trim();
        
        String alphanumeric = "abcdefghijklmnopqrstuvwxyz0123456789";
        int start = 0;
        int end = s.length()-1;
        
        while(start < end){
        	char sChar = s.charAt(start);
        	char eChar = s.charAt(end);
        	
        	// If they are all alphanumeric, equal?
        	if(alphanumeric.contains(sChar+"") && alphanumeric.contains(eChar+"")){
        		if(sChar != eChar){
        			return false;
        		}
        		else{
        			start++;
            		end--;
        		}
        	}
        	else{
        		if(!alphanumeric.contains(sChar+"")){
        			start++;
        		}
        		if(!alphanumeric.contains(eChar+"")){
        			end--;
        		}
        	}
        }
        return true;
    }
}
