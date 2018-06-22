/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> result1 = new Stack<Character>();
        Stack<Character> result2 = new Stack<Character>();
        for(Character c: S.toCharArray()){
        	if(!c.equals('#')){
        		result1.push(c);
        	}
        	else{
        		if(result1.size() > 0){
        			result1.pop();
        		}
        	}
        }
        
        for(Character c: T.toCharArray()){
        	if(!c.equals('#')){
        		result2.push(c);
        	}
        	else{
        		if(result2.size() > 0){
            		result2.pop();
        		}
        	}
        }
        
        if(result1.size() == 0 && result2.size() == 0){
        	return true;
        }
        else if(result1.size() == 0 || result2.size() == 0){
        	return false;
        }
        else if(result1.size() == result2.size()){
        	while(result1.size() != 0){
        		if(!result1.pop().equals(result2.pop())){
            		return false;
            	}
        	}
        }
        else{
        	return false;
        }
        	
        return true;
    }
}

// Solution 1: Build String
class Solution {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
}

// Solution 2: Two Pointer
// reverse two strings

