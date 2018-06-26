/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
         int[] ransom = new int[26];
        int[] mag = new int[26];
        
        for(Character c: ransomNote.toCharArray()){
        	ransom[c-'a']++;
        }
        
        for(Character c: magazine.toCharArray()){
        	mag[c -'a']++;
        }
        
        for(int i = 0; i < 26; i++){
        	if(mag[i] < ransom[i]){
        		return false;
        	}
        }
        return true;
    }
}
