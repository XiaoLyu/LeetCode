/*
We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

Example 1:
Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].
Note: The length of the input array will not exceed 20,000.
*/

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int num: nums){
			if(map.containsKey(num)){
				map.put(num, map.get(num) + 1);
			}
			else{
				map.put(num, 1);
			}
		}
		
		int sum = 0;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			if(map.containsKey(entry.getKey() + 1)){
				int temp = entry.getValue() + map.get(entry.getKey() + 1);
				if(temp > sum){
					sum = temp;
				}
			}
		}
		return sum;
    }
}
