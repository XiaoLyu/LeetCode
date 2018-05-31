/*
Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.


American keyboard


Example 1:
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
Note:
You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.
*/

class Solution {
    public String[] findWords(String[] words) {
        String[] line = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
		ArrayList<String> result = new ArrayList<String>();
		
		Map<Character, Integer> dictionary = new HashMap<Character, Integer>();
		
		for(int i = 0; i < 3; i++){
			for(char c: line[i].toCharArray()){
				dictionary.put(c, i);
			}
		}
		
		for(String c: words){
			int flag = 1;
			for(int i = 0 ; i < c.length(); i++){
				char cha = c.toLowerCase().charAt(i);
				
				char firstcha = c.toLowerCase().charAt(0);
				int index1 = dictionary.get(firstcha);
				
				if(dictionary.get(cha) != index1){
					flag = -1;
					break;
				}	
			}
			if(flag == 1){
				result.add(c);
			}
			
		}
		return result.toArray(new String[0]);
    }
}
