public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        			int rOfNums = nums.length;
			int cOfNums = nums[0].length;
			int[][] result = new int[r][c];
			
			if (rOfNums * cOfNums == c * r){
				for(int i = 0; i < r; i++){
					for(int j = 0; j < c; j++){
						int row = (int)(i * c + j + 1) / (int)cOfNums;
						int column = (i * c + j + 1 ) % (cOfNums);
						
						if(column == 0){
							result[i][j] = nums[row-1][cOfNums-1];
						}
						else{
							result[i][j] = nums[row][column - 1];
						}
					}
				}
				return result;
			}
			
			else{
				return nums;
			}
    }
}
