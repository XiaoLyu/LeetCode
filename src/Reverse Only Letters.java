/*
Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.

 

Example 1:

Input: "ab-cd"
Output: "dc-ba"
Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 

Note:

S.length <= 100
33 <= S[i].ASCIIcode <= 122 
S doesn't contain \ or "
*/

class Solution {
    public String reverseOnlyLetters(String S) {
        String s = "";
    	
    	int j = S.length()-1;
        for(int i = 0; i < S.length(); i++){
        	char current = S.charAt(i);
        	if(isLetter(current)){
        		if(isLetter(S.charAt(j))){
        			char temp = S.charAt(j);
        			s = s + temp;
        			j--;
         		}
        		else{
        			while(!isLetter(S.charAt(j))){
        				j--;
        			}
        			s = s + S.charAt(j);
        			j--;
        		}
        	}
        	else{
        		//keep it
        		s = s + S.charAt(i);
        	}
        }
        return s;
    }
    
    public boolean isLetter(char c){
    	if(('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')){
    		return true;
    	}
    	else
    		return false;
    }
}
