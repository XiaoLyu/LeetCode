/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
    	Set<Integer> set2 = new HashSet<Integer>();
    	
        for(int i = 0; i < nums1.length; i++){
        	set1.add(nums1[i]);
        }
        
        for(int i = 0; i < nums2.length; i++){
        	set2.add(nums2[i]);
        }
        
       	Set<Integer> set = new HashSet<Integer>();
        
        for(Integer item: set1){
        	if(set2.contains(item)){
        		set.add(item);
        	}
        }
       
        int[] result = new int[set.size()];
        int i = 0;
        for(Integer setItem: set){
        	result[i] = setItem;
        	i++;
        }
        return result;
    }
}
