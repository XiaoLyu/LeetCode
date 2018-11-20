/*
We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Return a list of all uncommon words. 

You may return the list in any order.

 

Example 1:

Input: A = "this apple is sweet", B = "this apple is sour"
Output: ["sweet","sour"]
Example 2:

Input: A = "apple apple", B = "banana"
Output: ["banana"]
 

Note:

0 <= A.length <= 200
0 <= B.length <= 200
A and B both contain only spaces and lowercase letters.
*/

import java.util.Map.Entry;
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        
        String[] As = A.split(" ");
        String[] Bs = B.split(" ");
        
        for(String str: As){
        	if(map.containsKey(str)){
        		map.put(str, map.get(str)+1);
        	}
        	else{
        		map.put(str, 1);
        	}
        }
    
        for(String str: Bs){
        	if(map.containsKey(str)){
        		//如果有相同 value = 0
        		map.put(str, 0);
        	}
        	else{
        		map.put(str, 1);
        	}
        }
        
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while(it.hasNext()){
        	Map.Entry<String, Integer> entry = it.next();
        	if(entry.getValue() == 0 || entry.getValue() > 1){
        		it.remove();
        	}
        }
        
        String[] result = new String[map.size()];
        int index = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
        	result[index] = entry.getKey();
        	index++;
        }
        return result;
    }
}
