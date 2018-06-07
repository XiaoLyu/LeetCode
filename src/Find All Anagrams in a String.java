/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        Map<Character, Integer> map = new HashMap<>();
        
        for(Character c: p.toCharArray()){
        	if(map.containsKey(c)){
        		map.put(c, map.get(c) + 1);
        	}
        	else{
        		map.put(c, 1);
        	}
        }
        
        int begin = 0, end = 0;
        int counter = map.size();
        
        while(end < s.length()){
        	Character c = s.charAt(end);
        	if(map.containsKey(c)){
        		map.put(c, map.get(c)-1);
        		if(map.get(c) == 0){
            		counter--;
            	}
        	}
        	
        	end++;
        	
        	// counter !!!这个地方超级厉害！！！
        	while(counter == 0){
        		if(end - begin == p.length()){
        			result.add(begin);
        		}
        		
        		Character t = s.charAt(begin);
        		if(map.containsKey(t)){
        			map.put(t, map.get(t) + 1);
        			if(map.get(t) > 0){
        				counter++;
        			}
        		}
        		begin++;
        	}
        }
        return result;
    }
}
