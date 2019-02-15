/*
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
*/

class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left < right && s.charAt(left) == s.charAt(right)){
            left++;
            right--;
        }
        
        if(left > right)    return true;
        return(isPalindrome(s, left+1, right) || isPalindrome(s, left, right-1));
    }
    
    public boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }
            else
                return false;
        }
        
        return true;
    }
}
