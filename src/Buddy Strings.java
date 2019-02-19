/*
Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.

 

Example 1:

Input: A = "ab", B = "ba"
Output: true
Example 2:

Input: A = "ab", B = "ab"
Output: false
Example 3:

Input: A = "aa", B = "aa"
Output: true
Example 4:

Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true
Example 5:

Input: A = "", B = "aa"
Output: false
 

Note:

0 <= A.length <= 20000
0 <= B.length <= 20000
A and B consist only of lowercase letters.
*/

class Solution {
    public boolean buddyStrings(String A, String B) {
        int ALen = A.length();
        int BLen = B.length();
        boolean result = false;
        
        if(ALen == BLen){
            if(A.equals(B)){
                // check duplicates
                Set<Character> set = new HashSet<>();
                for(int i = 0; i < ALen; ++i){
                    if(!set.contains(A.charAt(i))){
                        set.add(A.charAt(i));
                    }
                    else{
                        result = true;
                        return result;
                    }
                }
            }
            else{
                String As = "";
                String Bs = "";
                    
                for(int i = 0; i < ALen; ++i){
                    if(A.charAt(i) != B.charAt(i)){
                        As = As + A.charAt(i);
                        Bs = Bs + B.charAt(i);
                    }
                }
                
                if(As.length() == Bs.length() && As.length() == 2){
                    if(As.charAt(0) == Bs.charAt(1) && As.charAt(1) == Bs.charAt(0)){
                        result = true;
                    }
                }
            }
        }
        
        return result;
    }
}
