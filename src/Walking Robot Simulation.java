/*
A robot on an infinite grid starts at point (0, 0) and faces north.  The robot can receive one of three possible types of commands:

-2: turn left 90 degrees
-1: turn right 90 degrees
1 <= x <= 9: move forward x units
Some of the grid squares are obstacles. 

The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])

If the robot would try to move onto them, the robot stays on the previous grid square instead (but still continues following the rest of the route.)

Return the square of the maximum Euclidean distance that the robot will be from the origin.

 

Example 1:

Input: commands = [4,-1,3], obstacles = []
Output: 25
Explanation: robot will go to (3, 4)
Example 2:

Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
Output: 65
Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)
 

Note:

0 <= commands.length <= 10000
0 <= obstacles.length <= 10000
-30000 <= obstacle[i][0] <= 30000
-30000 <= obstacle[i][1] <= 30000
The answer is guaranteed to be less than 2 ^ 31.
*/

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0;
        
        // direction 0:up, 1:right, 2:down, 3:left
        int direction = 0;
        Set<String> set = new HashSet<>();
        for(int[] obs : obstacles){
            set.add(obs[0] + " " + obs[1]);
        }
        
        int[][] moves = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int result = 0;
        for(int i = 0; i < commands.length; i++){
            if(commands[i] == -1){
                direction++;
                if(direction == 4)  direction = 0;
            }
            if(commands[i] == -2){
                direction--;
                if(direction == -1) direction = 3;
            }
            if(commands[i] >= 1 && commands[i] <= 9){
                int c = commands[i];
                while(c > 0 && !set.contains((x+moves[direction][0]) + " " + (y + moves[direction][1]))){
                    x = x + moves[direction][0];
                    y = y + moves[direction][1];
                    c--;
                }
            }
            result = Math.max(result, x * x + y * y);
        }
        
        return result;
    }
}
