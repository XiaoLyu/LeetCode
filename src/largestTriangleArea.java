/*
You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the points.

Example:
Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
Output: 2
Explanation: 
The five points are show in the figure below. The red triangle is the largest.


Notes:

3 <= points.length <= 50.
No points will be duplicated.
 -50 <= points[i][j] <= 50.
Answers within 10^-6 of the true value will be accepted as correct.
*/

class Solution {
    public double largestTriangleArea(int[][] points) {
        double result = Double.MIN_VALUE;
        for(int i = 0; i < points.length; i++){
        	for(int j = 0; j < points.length; j++){
        		for(int k = 0; k < points.length; k++){
        			if((i != j)&&(j != k)&&(i != k)){
        				double distance1 = distance(points[i], points[j]);
        				double distance2 = distance(points[i], points[k]);
        				double distance3 = distance(points[k], points[j]);
        				double s = (distance1 + distance2 + distance3)/2;
        				double area = Math.sqrt(s*(s-distance1)*(s-distance2)*(s-distance3));
        				
        				if(area > result){
        					result = area;
        				}
        			}
        		}
        	}
        }
        return result;
    }
    
    public double distance(int[] point1, int[] point2){
    	double x = point1[0] - point2[0];
    	double y = point1[1] - point2[1];
    	double distance = Math.sqrt(x*x + y*y);
    	return distance;
    }
}
