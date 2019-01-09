/*
In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty. 

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

Return that maximum distance to closest person.

Example 1:

Input: [1,0,0,0,1,0,1]
Output: 2
Explanation: 
If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.
Example 2:

Input: [1,0,0,0]
Output: 3
Explanation: 
If Alex sits in the last seat, the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.
Note:

1 <= seats.length <= 20000
seats contains only 0s or 1s, at least one 0, and at least one 1.
*/

class Solution {
    public int maxDistToClosest(int[] seats) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < seats.length; i++){
        	if(seats[i] == 1){
        		list.add(i);
        	}
        }
        
        if(list.size() <= 0){
        	return 0;
        }
        
        if(list.size() == 1){
        	return Math.max(list.get(0), seats.length-list.get(0)-1);
        }
        
        else{
        	int result = 0;
        	if(list.get(0) != 0){
        		result = list.get(0);
        	}
        	for(int i = 1; i < list.size(); i++){
        		int dis = (list.get(i) - list.get(i-1))/2;
        		if(dis > result){
        			result = dis;
        		}
        	}
        	if(list.get(list.size()-1) != (seats.length-1)){
        		int d = seats.length - 1 - list.get(list.size() - 1);
        		if(d > result){
        			result = d;
        		}
        	}
        	return result;
        }
    }
}
