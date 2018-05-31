/*
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
    	for(int i = 0; i < s.length(); i++){
    		if(!map.containsKey(s.charAt(i))){
    			map.put(s.charAt(i), 1);
    		}
    		else{
    			map.put(s.charAt(i), map.get(s.charAt(i))+1);
    		}
    	}
    	
    	int result = 0;
    	int remain = Integer.MIN_VALUE;
    	
    	for(Map.Entry<Character, Integer> entry : map.entrySet()){
    		if(entry.getValue() % 2 == 0){
    			result = result + entry.getValue();
    		}
    		else{
                result = result + entry.getValue() - 1;
    			if(entry.getValue() >= remain){
    				remain = entry.getValue();
    			}
    		}
    	}
    	if(remain != Integer.MIN_VALUE){
    		result = result + 1;
    	}
    	return result;
    }
}
