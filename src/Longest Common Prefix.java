/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if(strs.length > 0){
            result = strs[0];
            for(int i = 1; i < strs.length; ++i){
                result = commonPre(strs[i], result);
            }
        }
        return result;
    }
    
    public String commonPre(String str, String result){
        int lenOfStr = str.length();
        int lenOfResult = result.length();
        String s = "";
        for(int i = 0; i < Math.min(lenOfStr, lenOfResult); ++i){
            if(str.charAt(i) == result.charAt(i)){
                s = s + str.charAt(i);
            }
            else{
                break;
            }
        }
        return s;
    }
}
