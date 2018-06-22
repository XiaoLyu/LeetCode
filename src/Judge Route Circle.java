/*
Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true
Example 2:
Input: "LL"
Output: false
*/

class Solution {
    public boolean judgeCircle(String moves) {
        int UD = 0;
		int LR = 0;
		for(Character c: moves.toCharArray()){
			switch(c){
				case 'U':
					UD++;
					break;
				case 'D':
					UD--;
					break;
				case 'L':
					LR--;
					break;
				case 'R':
					LR++;
					break;
			}
		}
		if(UD == 0 && LR == 0){
			return true;
		}
		return false;
    }
}
