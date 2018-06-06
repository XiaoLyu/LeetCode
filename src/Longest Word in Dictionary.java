/*
Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.
Example 1:
Input: 
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation: 
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:
Input: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation: 
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
Note:

All the strings in the input will only contain lowercase letters.
The length of words will be in the range [1, 1000].
The length of words[i] will be in the range [1, 30].
*/

class Solution {
    class Trie{
		class Node{
			Node[] next = new Node[26];
			boolean isEnd;
		}
		
		Node root;
		
		public Trie(){
			root = new Node();
			root.isEnd = true;
		}
		
		public void insert(String s){
			Node node = root;
			for(Character c: s.toCharArray()){
				if(node.next[c-'a'] == null){
					node.next[c-'a'] = new Node();
				}
				node = node.next[c-'a'];
			}
			node.isEnd = true;
		}
		
		public boolean canForm(String s){
			Node node = root;
			for(Character c: s.toCharArray()){
				if(node.next[c-'a'] == null || node.next[c-'a'].isEnd != true){
					return false;
				}
				node = node.next[c-'a'];
			}
			return true;
		}
	}
	
    public String longestWord(String[] words) {
    	Trie trie = new Trie();
    	for(String word : words){
    		trie.insert(word);
    	}
    	String result = "";
    	for(String word : words){
    		if(word.length() >= result.length() && trie.canForm(word)){
    			if(word.length()  > result.length()){
    				result = word;
    			}
    			else{
    				result = word.compareTo(result) < 0 ? word : result;
    			}
    		}
    	}
        return result;
    }
}
