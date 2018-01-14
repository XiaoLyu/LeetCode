/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int lengthOfNums = nums.length;
        int[] result = new int[lengthOfNums];
        List<Integer> re = new ArrayList<Integer>();
        
        for(int i = 0; i < lengthOfNums; i++){
            int value = nums[i];
            result[value-1] = 1;
        }
        
        for(int i = 0; i < lengthOfNums; i++){
            if(result[i] != 1){
                re.add(i+1);
            }
        }
         return re;
    }
}
