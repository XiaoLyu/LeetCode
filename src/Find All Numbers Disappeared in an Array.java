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
