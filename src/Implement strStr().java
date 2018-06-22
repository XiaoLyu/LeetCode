/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
*/

//Brute-Force
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle != null && haystack != null && haystack.length() >= needle.length() && needle.length() > 0){
    		int start = 0;
    		int count = 0;
    		while(haystack.length() - start >= needle.length()){
    			if(haystack.charAt(count+start) == needle.charAt(count)){
    				count++;
    			}
    			else{
    				count = 0;
    				start++;
    			}
    			if(count == needle.length()){
    				return start;
    			}
    		}
    	}
        else if(needle.length() == 0){
    		return 0;
    	}
    	return -1;
    }
}

// KMP: 基于BF，不符合的时候移位不一样

// BM: Boyer-Moore,从needle右至左进行比较

// Sunday: 与BM类似。从左至右进行比较

// 438?
