/*
Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. Such a word is said to complete the given string licensePlate

Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.

It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.

The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.

Example 1:
Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
Output: "steps"
Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
Note that the answer is not "step", because the letter "s" must occur in the word twice.
Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
Example 2:
Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
Output: "pest"
Explanation: There are 3 smallest length words that contains the letters "s".
We return the one that occurred first.
Note:
licensePlate will be a string with length in range [1, 7].
licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
words will have a length in the range [10, 1000].
Every words[i] will consist of lowercase letters, and have length in range [1, 15].
*/

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        String result = "";
        
         for(Character c: licensePlate.toCharArray()){
        	if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
        		if(map.containsKey(Character.toLowerCase(c))){
            		map.put(Character.toLowerCase(c), map.get(Character.toLowerCase(c))+1);
            	}
            	else{
            		map.put(Character.toLowerCase(c), 1);
            	}
        	}
        }
        
        
        int len = Integer.MAX_VALUE;
        for(String str: words){
        	if(contain(str, map)){
        		if(str.length() < len){ 
        			len = str.length();
        			result = str;
        		}
        		else{
        			continue;
        		}
        	}
        }
        return result;
    }
    
    public boolean contain(String word, Map<Character, Integer> map){
    	Map<Character, Integer> mapCopy = new HashMap<Character, Integer>();
    	mapCopy.putAll(map);
    	for(Character c: word.toCharArray()){
    		if(mapCopy.containsKey(c) && mapCopy.get(c) > 0){
    			mapCopy.put(c, mapCopy.get(c)-1);
    		}
    	}
    	
    	boolean flag = true;
    	for(Map.Entry<Character, Integer> entry: mapCopy.entrySet()){
    		if(entry.getValue() != 0){
    			flag = false;
    			break;
    		}
    	}
    	return flag;
    }
}
