/*
In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

 

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 

Note:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are english lowercase letters.
*/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
    	for(int i = 0; i < order.length(); i++){
    		map.put(order.charAt(i), i);
    	}
    	
    	int l = words.length;
    	if (l <= 1){
    		return true;
    	}
    	for(int i = 0; i < l - 1; i++){
    		String word1 = words[i];
    		String word2 = words[i+1];
    		if(isSorted(word1, word2, map) == false){
    			return false;
    		}
    	}
    	return true;
    }
    
    public boolean isSorted(String word1, String word2, HashMap<Character, Integer> map){
    	boolean result = false;
    	
    	int len = Math.min(word1.length(), word2.length());
    	
    	for(int i = 0; i < len; i++){
    		char c1 = word1.charAt(i);
    		char c2 = word2.charAt(i);
    		int index1 = map.get(c1);
    		int index2 = map.get(c2);

    		if(index1 < index2){
    			return true;
    		}
    		if(index1 == index2){
    			continue;
    		}
    		
    		if(index1 > index2){
    			result = false;
    			return result;
    		}
    	}
    	
    	return result;
    }
}
