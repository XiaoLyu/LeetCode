/*
You are given a string representing an attendance record for a student. The record only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
Example 2:
Input: "PPALLL"
Output: False
*/

class Solution {
    public boolean checkRecord(String s) {
        int[] records = new int[2]; // [0]:A	[1]:L
        for(int i = 0; i < s.length(); i++){
        	Character c = s.charAt(i);
        	if(c.equals('L')){
        		records[1]++;
        		if(records[1] > 2){
        			return false;
        		}
        	}
        	if(c.equals('A')){
        		records[0]++;
        		records[1] = 0;
        	}
            if(c.equals('P')){
        		records[1] = 0;
        	}
        }
        if(records[0] > 1){
        	return false;
        }
        return true;
    }
}

// contains或者RE
