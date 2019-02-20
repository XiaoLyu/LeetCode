/*
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.

Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.

*/

class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0;
        while(!allRotten(grid)){
            int[][] gridAft = change(grid);
            if(same(grid, gridAft)) return -1;
            grid = gridAft;
            time++;
        }
        return time;
    }
    
    public boolean allRotten(int[][] grid){
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(grid[i][j] == 1){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean same(int[][] gridPre, int[][] gridAft){
        for(int i = 0; i < gridPre.length; ++i){
            for(int j = 0; j < gridPre[0].length; ++j){
                if(gridPre[i][j] != gridAft[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    
    public int[][] change(int[][] grid){
        int iLen = grid.length;
        int jLen = grid[0].length;
        int[][] gridAft = new int[iLen][jLen];
        
        for(int i = 0; i < iLen; ++i){
            for(int j = 0; j < jLen; ++j){
                if(grid[i][j] == 1 && 
                   ((j > 0 && grid[i][j-1] == 2) || ((j < (jLen-1)) && grid[i][j+1] == 2) || (i > 0 && grid[i-1][j] == 2) || (i < (iLen-1)) && grid[i+1][j] == 2)){
                    gridAft[i][j] = 2;
                }
                else{
                    gridAft[i][j] = grid[i][j];
                }
            }
        }
        return gridAft;
    }
}
