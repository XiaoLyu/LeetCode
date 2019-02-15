/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5
*/

class Solution {
    public int lengthOfLastWord(String s) {
        int result = 0;
        s = s.trim();
        for(int i = s.length()-1; i >= 0; --i){
            if(s.charAt(i) != ' '){
                result++;
            }
            else{
                return result;
            }
        }
        return result;
    }
}
