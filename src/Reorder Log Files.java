/*
You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.

 

Example 1:

Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 

Note:

0 <= logs.length <= 100
3 <= logs[i].length <= 100
logs[i] is guaranteed to have an identifier, and a word after the identifier.
*/

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letters = new ArrayList<String>();
    	List<String> digits = new ArrayList<String>();
    	
    	for(String str: logs){
    		int index = str.indexOf(" ");
    		char c = str.charAt(index+1);
    		if(c >= '0' && c <= '9'){
    			digits.add(str);
    		}
    		else{
    			letters.add(str);
    		}
    	}
    	
    	Collections.sort(letters, new Comparator<String>(){
    		@Override
    		public int compare(String s1, String s2){
    			int index1 = s1.indexOf(" ");
    			String id1 = s1.substring(0, index1);
    			String letter1 = s1.substring(index1+1);
    			
    			int index2 = s2.indexOf(" ");
    			String id2 = s2.substring(0, index2);
    			String letter2 = s2.substring(index2+1);
    			
    			int c1 = letter1.compareTo(letter2);
    			if(c1 != 0){
    				return c1;
    			}
    			else{
    				return (id1.compareTo(id2));
    			}
    		}
    	});
    	
    	String[] result = new String[letters.size() + digits.size()];
    	int i = 0;
    	for(String s1: letters){
    		result[i++] = s1;
    	}
    	
    	for(String s1: digits){
    		result[i++] = s1;
    	}
    	
    	return result;
    }
}
