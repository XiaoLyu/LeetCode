/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
*/

class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        Map<Character, Integer> map = new HashMap<>();
        map.put('(', 1);
        map.put(')', -1);
        map.put('{', 2);
        map.put('}', -2);
        map.put('[', 3);
        map.put(']', -3);
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); ++i){
        	char cur = s.charAt(i);
        	if(map.containsKey(cur)){
        		if(map.get(cur) > 0){
        			stack.push(map.get(cur));
        		}
        		else{
        			if(!stack.isEmpty()){
        				if(stack.pop() + map.get(cur) != 0){
            				return false;
            			}
        			}
        		}
        	}
        	else{
        		return false;
        	}
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
