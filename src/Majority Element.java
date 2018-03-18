/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

*／

／*
HashMap存key-value
*/

class Solution {
    public int majorityElement(int[] nums) {
       HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(!hashMap.containsKey(nums[i])){
                hashMap.put(nums[i], 1);
            }
            else{
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            }
        }
        
        int halftime = nums.length / 2;
        int result = 0;
        Iterator iter = hashMap.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            if((Integer)entry.getValue() > halftime){
                result = (Integer)entry.getKey();
            }
        }
        
        return result;
	}
}

