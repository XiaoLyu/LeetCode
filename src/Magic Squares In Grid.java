/*
A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.

Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).

 

Example 1:

Input: [[4,3,8,4],
        [9,5,1,9],
        [2,7,6,2]]
Output: 1
Explanation: 
The following subgrid is a 3 x 3 magic square:
438
951
276

while this one is not:
384
519
762

In total, there is only one magic square inside the given grid.
Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
0 <= grid[i][j] <= 15
*/

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int result = 0;
		if(grid.length >=3 && grid[0].length >= 3){
			int x = grid.length - 3; // x 最后的index
			int y = grid[0].length - 3; // y 最后的index
			
			for(int i = 0; i <= x; i++){
				for(int j = 0; j <= y; j++){
					if(magic(grid, i, j)){
						result++;
					}
				}
			}
		}
		return result;
	}
	
	public static boolean magic(int[][] grid, int r, int c){
		boolean flag = true;
		if(uniq(grid, r, c) && rc(grid, r, c) && diagonals(grid, r, c)){
			flag = true;
		}
		else{
			flag = false;
		}
		return flag;
	}
	
	public static boolean uniq(int[][] grid, int r, int c){
		List<Integer> list = new ArrayList<Integer>();
		boolean flag = true;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(!list.contains(grid[r+i][c+j]) && grid[r+i][c+j] >= 0 && grid[r+i][c+j] <= 9){
					list.add(grid[r+i][c+j]);
				}
				else{
					flag = false;
				}
			}
		}
		return flag;
	}
	
	public static boolean rc(int[][] grid, int r, int c){
		boolean flag = true;
		
		for(int i = 0; i < 3; i++){
			int Rsum = 0;
			int Csum = 0;
			for(int j = 0; j < 3; j++){
				Rsum = Rsum + grid[r+i][c+j];
				Csum = Csum + grid[r+j][c+i];
			}
			if(Rsum != 15 || Csum != 15){
				flag = false;
			}
		}
		return flag;
	}
	
	public static boolean diagonals(int[][] grid, int r, int c){
		boolean flag = true;
		int left2right = 0;
		int right2left = 0;
		
		for(int i = 0; i < 3; i++){
			left2right = left2right + grid[r+i][c+i];
			right2left = right2left + grid[r+i][c+2-i];
		}
		
		if(left2right != 15 || right2left != 15){
			flag = false;
		}
		
		return flag;
	}
}
