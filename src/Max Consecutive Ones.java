public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int[] result = new int[nums.length];
        int max = 0;
        
        if(nums[0] == 1){
            result[0] = 1;
        }
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == 1){
                result[i] = result[i-1] + 1;
            }
        }
        
        for (int i = 0; i < nums.length; i++){
            if(result[i] > max){
                max = result[i];
            }
        }
        
        return max;
    }
}
