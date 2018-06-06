/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
       for(int i = 0; i < s.length(); i++){
    	   if(getFirstIndex(i, s) != getFirstIndex(i, t)) return false;
       }
       return true;
    }
    
    public int getFirstIndex(int position, String s){
    	Character c = s.charAt(position);
    	int index = s.indexOf(c);
    	int result = (index < position) ? index : position;
    	return result;
    }
}
