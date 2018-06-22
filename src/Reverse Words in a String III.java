/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
*/

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
		StringBuilder result = new StringBuilder();
		// reverse every word
		for(String word: words){
			char[] wordChar = word.toCharArray();
			int start = 0;
			int end = word.length()-1;
			while(start < end){
				char temp = wordChar[start];
				wordChar[start] = wordChar[end];
				wordChar[end] = temp;
				start ++;
				end--;
			}
			result.append(String.valueOf(wordChar));
			result.append(" ");
		}
		return result.substring(0, result.length()-1);
    }
}
