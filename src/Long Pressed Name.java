/*
Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.

 

Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
Example 2:

Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
Example 3:

Input: name = "leelee", typed = "lleeelee"
Output: true
Example 4:

Input: name = "laiden", typed = "laiden"
Output: true
Explanation: It's not necessary to long press any character.
 

Note:

name.length <= 1000
typed.length <= 1000
The characters of name and typed are lowercase letters.

*/

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
    	int j = 0;
    	boolean result = true;
    	while(i < name.length()){
    		char current = name.charAt(i);
    		int same1 = 0;
        	int same2 = 0;
        	while(i < name.length() && name.charAt(i) == current){
        		same1++;
        		i++;
        	}
        	while(j < typed.length() && typed.charAt(j) == current){
        		same2++;
        		j++;
        	}
        	if(same1 > same2){
        		result = false;
        		break;
        	}
    	}
    	return result;
    }
}
