/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

*/

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
    	
        for(int i = 0; i < s.length(); i++){
        	if(!map.containsKey(s.charAt(i))){
        		map.put(s.charAt(i), 1);
        	}
        	else{
        		map.put(s.charAt(i), map.get(s.charAt(i))+1);
        	}
        }
        
        int min = Integer.MAX_VALUE;
        if(map.size() == 0 || map == null){
        	min = -1;
        }
        else{
        	for(Map.Entry<Character, Integer> entry : map.entrySet()){
            	if(entry.getValue() == 1){
            		int index = s.indexOf(entry.getKey());
            		if(index < min){
            			min = index;
            		}
            	}
        	}
        }
    	if(min == Integer.MAX_VALUE){
        	min = -1;
        }
    	return min;
    }
}
